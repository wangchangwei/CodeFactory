package cn.afterturn.gen.modular.requirement.service.impl;

import cn.afterturn.gen.common.exception.BizExceptionEnum;
import cn.afterturn.gen.common.exception.BussinessException;
import cn.afterturn.gen.config.properties.GunsProperties;
import cn.afterturn.gen.modular.requirement.model.Module;
import cn.afterturn.gen.modular.requirement.dao.ModuleMapper;
import cn.afterturn.gen.modular.requirement.service.ModuleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.UUID;


/**
 * 模型管理-服务实现
 * @author : 王长伟
 * @date : 2023-09-17 17:10:30
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService  {

    @Resource
    private GunsProperties gunsProperties;
    public String upload(MultipartFile picture) {
        String pictureName = UUID.randomUUID().toString() + ".jpg";
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();
            picture.transferTo(new File(fileSavePath + pictureName));
        } catch (Exception e) {
            throw new BussinessException(BizExceptionEnum.UPLOAD_ERROR);
        }
        return pictureName;
    }
}
            