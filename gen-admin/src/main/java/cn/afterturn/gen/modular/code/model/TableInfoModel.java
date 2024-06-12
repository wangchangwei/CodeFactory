package cn.afterturn.gen.modular.code.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @author JueYue
 * @Date 2017-09-20 09:18
 */
@TableName("t_code_table_head")
@Data
public class TableInfoModel extends CodeBaseModel<TableInfoModel> {

    private static final long serialVersionUID = 1L;

    public TableInfoModel() {

    }

    public TableInfoModel(Integer id) {
        this.id = id;
    }

    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 拥有人
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 表名
     */
    @TableField(value = "table_name")
    private String tableName;

    /**
     * ClassName
     */
    @TableField(value = "class_name")
    private String className;

    /**
     * 表名称
     */
    @TableField(value = "content")
    private String content;

    /**
     * 是否导入Excel
     */
    @TableField(value = "is_import")
    private Integer isImport;

    /**
     * 是否导出Excel
     */
    @TableField(value = "is_export")
    private Integer isExport;

    /**
     * 是否分页
     */
    @TableField(value = "is_pagination")
    private Integer isPagination;

    /**
     * 是否添加日志
     */
    @TableField(value = "is_log")
    private Integer isLog;

    /**
     * 是否添加协议
     */
    @TableField(value = "is_protocol")
    private Integer isProtocol;

    @TableField(exist = false)
    private List<TableServiceConfigModel> serviceConfig;

    @TableField(exist = false)
    private List<TableFieldModel> tableFields;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @TableField(exist = false)
    private List<TemplateGroupModel> templateGroupModelList;

}
