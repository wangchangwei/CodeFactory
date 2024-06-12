package cn.afterturn.gen.core.model;

import freemarker.template.utility.CollectionUtils;
import org.abego.treelayout.internal.util.java.util.ListUtil;
import org.beetl.ext.fn.ArrayUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据库表属性
 *
 * @author JueYue
 * @date 2014年12月21日
 */
public class GenBeanEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 表名
     */
    private String tableName;
    /**
     * Java 表名
     */
    private String name;
    /**
     * 中文名称
     */
    private String chinaName;
    /**
     * 注释
     */
    private String comment;
    /**
     * 是否导入Excel
     */
    private Integer isImport = 1;

    /**
     * 是否导出Excel
     */
    private Integer isExport = 1;
    /**
     * 是否生产API接口
     */
    private Integer api = 1;

    /**
     * 是否分页
     */
    private Integer isPagination = 1;

    /**
     * 是否添加日志
     */
    private Integer isLog = 1;

    /**
     * 是否添加协议
     */
    private Integer isProtocol = 1;
    /**
     * 表字段
     */
    private List<GenFieldEntity> fields;

    private List<GenFieldEntity> formFields;

    private List<GenFieldEntity> requestFields;

    private List<GenFieldEntity> responseFields;

    public List<GenFieldEntity> getRequestFields() {
        return requestFields;
    }

    public void setRequestFields(List<GenFieldEntity> requestFields) {
        this.requestFields = requestFields;
    }

    public List<GenFieldEntity> getResponseFields() {
        return responseFields;
    }

    public void setResponseFields(List<GenFieldEntity> responseFields) {
        this.responseFields = responseFields;
    }

    public List<GenFieldEntity> getFields() {
        return fields;
    }

    public void setFields(List<GenFieldEntity> fields) {
        this.fields = fields;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChinaName() {
        return chinaName;
    }

    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }

    public Integer getIsImport() {
        return isImport;
    }

    public void setIsImport(Integer isImport) {
        this.isImport = isImport;
    }

    public Integer getIsExport() {
        return isExport;
    }

    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }

    public Integer getIsPagination() {
        return isPagination;
    }

    public void setIsPagination(Integer isPagination) {
        this.isPagination = isPagination;
    }

    public Integer getIsLog() {
        return isLog;
    }

    public void setIsLog(Integer isLog) {
        this.isLog = isLog;
    }

    public Integer getIsProtocol() {
        return isProtocol;
    }

    public void setIsProtocol(Integer isProtocol) {
        this.isProtocol = isProtocol;
    }

    public Integer getApi() {
        return api;
    }

    public void setApi(Integer api) {
        this.api = api;
    }

    public List<GenFieldEntity> getFormFields() {
        if (fields !=null && fields.size()>0){
            return fields.stream().filter(item->{
                if ("createdAt".equals(item.getName())){return false;}
                if ("modifiedAt".equals(item.getName())){return false;}
                if ("createUserId".equals(item.getName())){return false;}
                if ("createUser".equals(item.getName())){return false;}
                if ("updateUser".equals(item.getName())){return false;}
                if ("updateUserId".equals(item.getName())){return false;}
                if ("version".equals(item.getName())){return false;}
                if ("delFlag".equals(item.getName())){return false;}
                if ("createDeptId".equals(item.getName())){return false;}
                if ("id".equals(item.getName())){return false;}
                if (item.getIsShowAdd()==null || item.getIsShowAdd()==0){return false;}
                return true;
            }).collect(Collectors.toList());
        }
        return formFields;
    }

    public void setFormFields(List<GenFieldEntity> formFields) {
        this.formFields = formFields;
    }
}
