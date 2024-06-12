 package cn.afterturn.gen.modular.requirement.service;


 import cn.afterturn.gen.common.exception.BizExceptionEnum;
 import cn.afterturn.gen.common.exception.BussinessException;
 import cn.afterturn.gen.modular.requirement.model.Module;
 import com.baomidou.mybatisplus.service.IService;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RequestPart;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.multipart.MultipartFile;

 import java.io.File;
 import java.util.UUID;

 /**
  * 模型管理-服务实现
  * @author : 王长伟
  * @date : 2023-09-17 17:05:33
  */
 public interface ModuleService extends IService<Module> {

   String upload(MultipartFile picture);

 }

