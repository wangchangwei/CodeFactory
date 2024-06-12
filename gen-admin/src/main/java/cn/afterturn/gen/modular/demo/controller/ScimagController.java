 package cn.afterturn.gen.modular.demo.controller;

import cn.afterturn.gen.modular.demo.service.ScimagService;
import cn.afterturn.gen.modular.demo.service.impl.ScimagServiceImpl;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.entity.Column;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.afterturn.gen.modular.demo.entity.Scimag;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

 /**
 * 科研论文-接口
 * @author : code-general
 * @date : 2023-05-31 08:53:26
 */
@CrossOrigin
@RestController
@RequestMapping("/scimags")
public class ScimagController {

    @Resource
   ScimagService scimagService;

    @RequestMapping("/search")
    public List<Scimag> listTop(@Param("searchKey") String searchKey){
        if (StrUtil.isBlank(searchKey)){
            return new ArrayList<>();
        }
        EntityWrapper<Scimag> scimagEntityWrapper = new EntityWrapper<>();
        scimagEntityWrapper.like("title",searchKey).or().like("author",searchKey).last("limit 10");
        scimagEntityWrapper.setSqlSelect("id","title","doi","doi2","year","month","day","issnp","issne","journal");
        return  scimagService.selectList(scimagEntityWrapper);
    }
} 