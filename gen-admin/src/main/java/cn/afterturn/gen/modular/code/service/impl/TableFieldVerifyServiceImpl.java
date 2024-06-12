package cn.afterturn.gen.modular.code.service.impl;

import cn.afterturn.gen.modular.code.dao.TableFieldVerifyDao;
import cn.afterturn.gen.modular.code.model.TableFieldVerifyModel;
import cn.afterturn.gen.modular.code.service.ITableFieldVerifyService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-20 09:24
 */
@Service
public class TableFieldVerifyServiceImpl extends ServiceImpl<TableFieldVerifyDao, TableFieldVerifyModel> implements ITableFieldVerifyService {

    @Autowired
    private TableFieldVerifyDao tableFieldVerifyDao;


    @Override
    public TableFieldVerifyModel selectById(Integer id) {
        return tableFieldVerifyDao.selectById(id);
    }



    @Override
    public List<TableFieldVerifyModel> selectList(TableFieldVerifyModel model) {
        return tableFieldVerifyDao.selectList(model);
    }

    @Override
    public List<TableFieldVerifyModel> selectPage(Pagination pagination, TableFieldVerifyModel model, Wrapper<TableFieldVerifyModel> wrapper) {
        return tableFieldVerifyDao.selectPage(pagination,model,wrapper);
    }

    @Override
    public Integer deleteByFieldIds(List<Integer> fieldIds) {
        return tableFieldVerifyDao.deleteByFieldIds(fieldIds);
    }

    @Override
    public Integer batchInsert(List<TableFieldVerifyModel> verifyModelList) {
        return tableFieldVerifyDao.batchInsert(verifyModelList);
    }

}
