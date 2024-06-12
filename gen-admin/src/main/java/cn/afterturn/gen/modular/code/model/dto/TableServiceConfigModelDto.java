package cn.afterturn.gen.modular.code.model.dto;

import cn.afterturn.gen.modular.code.model.TableServiceConfigModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 表服务配置模型dto
 *
 * @author David
 * @date 2023/01/29
 */
public class TableServiceConfigModelDto{

    /**
     * 设置默认的表结构
     * @return
     */
    public static List<TableServiceConfigModel> getDefaultServiceConfig() {
        List<TableServiceConfigModel> list = new ArrayList<TableServiceConfigModel>();
        list.add(new TableServiceConfigModel("list", 2, 1, 1, "01"));
        list.add(new TableServiceConfigModel("add", 2, 1, 1, "01"));
        list.add(new TableServiceConfigModel("edit", 2, 1, 1, "01"));
        list.add(new TableServiceConfigModel("delete", 2, 1, 1, "01"));
        list.add(new TableServiceConfigModel("detail", 2, 1, 1, ""));
        return list;
    }
}
