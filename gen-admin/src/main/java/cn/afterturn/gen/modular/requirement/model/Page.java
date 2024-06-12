package cn.afterturn.gen.modular.requirement.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

 /**
 * 页面管理-实体
 * @author : 王长伟
 * @date : 2023-09-18 17:00:13
 */
@TableName("t_page")
@Getter
@Setter
public class Page extends Model<Page>  {

	  /** id */
		private Integer id;
	
	  /** 页面名称 */
		private String pageName;
	
	  /** 页面类型 */
		private String pageType;

		private String files;

		@TableField(exist = false)
	  /** 页面数量 */
		private Integer pageElementCount;
	
	  /** 模型id */
		private Integer moduleId;
	

@Override
	protected Serializable pkVal() {
		return null;
	}
}