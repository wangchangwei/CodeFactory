package cn.afterturn.gen.modular.requirement.model;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 模型管理-实体
 * @author : 王长伟
 * @date : 2023-09-17 16:46:24
 */
@TableName("t_module")
@Getter
@Setter
public class Module extends Model<Module>  {

	/** id */
	private Integer id;

	/** 模型名称 */
	private String modelName;

	/** 使用范围 */
	private String useScope;

	/** 业务描述 */
	private String description;


	@Override
	protected Serializable pkVal() {
		return null;
	}
}