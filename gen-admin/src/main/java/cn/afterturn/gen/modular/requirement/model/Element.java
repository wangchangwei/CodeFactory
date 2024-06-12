package cn.afterturn.gen.modular.requirement.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

 /**
 * 元素管理-实体
 * @author : 王长伟
 * @date : 2023-09-18 19:44:46
 */
@TableName("t_element")
@Getter
@Setter
public class Element extends Model<Element>  {

	  /** id */
		private Integer id;
	
	  /** 模型id */
		private Integer moduleId;
	
	  /** 页面id */
		private Integer pageId;
	
	  /** 元素名称 */
		private String elementName;
	
	  /** 元素类型 */
		private String elementType;
	
	  /** 元素规则 */
		private String elementRules;
	
	  /** 选择类型 */
		private String checkType;
	
	  /** 字典名称 */
		private String dictName;
	
	  /** 交互方式 */
		private String interactiveMethods;
	
	  /** 触发事件 */
		private String triggerEvent;
	

@Override
	protected Serializable pkVal() {
		return null;
	}
}