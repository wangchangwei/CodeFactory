package cn.afterturn.gen.modular.code.service.impl.convert;

import cn.afterturn.gen.core.model.GenBeanEntity;
import cn.afterturn.gen.core.model.GenFieldEntity;
import cn.afterturn.gen.core.model.enmus.BooleanType;
import cn.afterturn.gen.core.model.enmus.QueryType;
import cn.afterturn.gen.modular.code.model.TableFieldDbinfoModel;
import cn.afterturn.gen.modular.code.model.TableFieldModel;
import cn.afterturn.gen.modular.code.model.TableFieldVerifyModel;
import cn.afterturn.gen.modular.code.model.TableInfoModel;
import cn.afterturn.gen.modular.code.model.dto.TableServiceConfigModelDto;
import cn.afterturn.gen.modular.code.service.ITableConvertServer;
import cn.afterturn.gen.modular.code.service.ITableInfoService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 导入的数据库版本实现
 *
 * @author JueYue on 2017/10/25.
 */
@Service("dbTableConvertServer")
public class TableConvertServiceOfDbImpl implements ITableConvertServer {

    @Autowired
    private ITableInfoService tableInfoService;

    @Override
    public void importBean(String json, int userId) {
        GenBeanEntity bean = JSON.parseObject(json, GenBeanEntity.class);
        TableInfoModel entity = new TableInfoModel();
        entity.setClassName(bean.getName());
        if (StringUtils.isEmpty(bean.getChinaName())) {
            entity.setContent(bean.getTableName());
        } else {
            entity.setContent(bean.getChinaName());
        }
        entity.setTableName(bean.getTableName());
        entity.setUserId(userId);
        entity.setServiceConfig(TableServiceConfigModelDto.getDefaultServiceConfig());
        entity.setTableFields(getTableFields(bean.getFields()));
        tableInfoService.insert(entity, userId);
    }

    private List<TableFieldModel> getTableFields(List<GenFieldEntity> fields) {
        List<TableFieldModel> list = new ArrayList<TableFieldModel>();
        TableFieldModel fieldModel;
        GenFieldEntity tableField;
        TableFieldVerifyModel verifyModel;
        TableFieldDbinfoModel dbinfoModel;
        for (int i = 0; i < fields.size(); i++) {
            fieldModel = new TableFieldModel();
            tableField = fields.get(i);
            fieldModel.setFieldName(tableField.getFieldName());
            fieldModel.setName(tableField.getName());
            fieldModel.setContent(tableField.getChinaName());
            fieldModel.setType(tableField.getType());
            fieldModel.setIsKey(tableField.getKey());
            fieldModel.setIsQuery(BooleanType.YES.getIntD());
            fieldModel.setQueryMode(QueryType.EQ.getCode());
            fieldModel.setShowType("文本");
            fieldModel.setOrderNum(i+1);
            fieldModel.setDictType(0);
            verifyModel = new TableFieldVerifyModel();
            verifyModel.setNotNull(tableField.getNotNull());
            fieldModel.setVerifyModel(verifyModel);
            dbinfoModel = new TableFieldDbinfoModel();
            dbinfoModel.setFieldName(tableField.getFieldName());
            dbinfoModel.setFieldContent(tableField.getComment());
            dbinfoModel.setFieldLength(tableField.getFieldLength());
            dbinfoModel.setFieldPointLength(tableField.getFieldPointLength());
            dbinfoModel.setFieldType(tableField.getFieldType());
            fieldModel.setDbinfoModel(dbinfoModel);
            list.add(fieldModel);
        }
        return list;
    }


}
