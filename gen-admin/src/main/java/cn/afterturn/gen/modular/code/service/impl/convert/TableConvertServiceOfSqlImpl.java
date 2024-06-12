package cn.afterturn.gen.modular.code.service.impl.convert;

import cn.afterturn.gen.core.db.convert.sql.SqlConvertFactory;
import cn.afterturn.gen.core.model.GenBeanEntity;
import cn.afterturn.gen.modular.code.service.ITableConvertServer;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 导入的sql实现
 *
 * @author JueYue on 2017/10/25.
 */
@Service("sqlTableConvertServer")
public class TableConvertServiceOfSqlImpl implements ITableConvertServer {

    @Resource(name = "dbTableConvertServer")
    private ITableConvertServer tableConvertServer;

    @Override
    public void importBean(String json, int userId) {
        Map<String, String> map = JSON.parseObject(json, Map.class);
        String dbType = map.get("dbType");
        String sql = map.get("sql");
        GenBeanEntity beanEntity = SqlConvertFactory.getReadTable(dbType).parseSql(sql);
        tableConvertServer.importBean(JSON.toJSONString(beanEntity), userId);

    }
}
