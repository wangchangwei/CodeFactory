package cn.afterturn.gen.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * 
 *
 * @author David
 * @Date 2023-01-30 10:26
 */
@TableName("t_error_code")
public class ErrorCodeModel extends Model<ErrorCodeModel> {

    private static final long serialVersionUID = 1L;

	
	 /**
	 * Id
	 *
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;

	 /**
	 * Code
	 *
	 */
	@TableField(value="code")
	private Integer code;

	/**
	 * Code
	 *
	 */
	@TableField(value="code_type")
	private Integer codeType;

	 /**
	 * CnText
	 *
	 */
	@TableField(value="cn_text")
	private String cnText;

	 /**
	 * EnText
	 *
	 */
	@TableField(value="en_text")
	private String enText;


	 /**
	 * 获取: Id
	 *
	 */
	public Integer getId() {
	return id;
	}
	 /**
	 * 设置: Id
	 *
	 */
	public void setId(Integer id) {
	this.id = id;
	}
	 /**
	 * 获取: Code
	 *
	 */
	public Integer getCode() {
	return code;
	}
	 /**
	 * 设置: Code
	 *
	 */
	public void setCode(Integer code) {
	this.code = code;
	}
	 /**
	 * 获取: CnText
	 *
	 */
	public String getCnText() {
	return cnText;
	}
	 /**
	 * 设置: CnText
	 *
	 */
	public void setCnText(String cnText) {
	this.cnText = cnText;
	}
	 /**
	 * 获取: EnText
	 *
	 */
	public String getEnText() {
	return enText;
	}
	 /**
	 * 设置: EnText
	 *
	 */
	public void setEnText(String enText) {
	this.enText = enText;
	}


	public Integer getCodeType() {
		return codeType;
	}

	public void setCodeType(Integer codeType) {
		this.codeType = codeType;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
