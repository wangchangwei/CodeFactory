package cn.afterturn.gen.modular.requirement.controller;

import cn.afterturn.gen.common.constant.factory.PageFactory;
import cn.afterturn.gen.common.exception.BizExceptionEnum;
import cn.afterturn.gen.common.exception.BussinessException;
import cn.afterturn.gen.core.base.controller.BaseController;
import cn.afterturn.gen.core.util.ToolUtil;
import cn.afterturn.gen.modular.requirement.model.Module;
import cn.afterturn.gen.modular.requirement.service.ModuleService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import cn.afterturn.gen.modular.requirement.service.PageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 页面管理控制器
 *
 * @author 王长伟
 * @Date 2023-09-18 17:00:13
 */
@Controller
@RequestMapping("requirement/page")
public class PageController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

    private String PREFIX = "/requirement/";

    @Autowired
    private PageService pageService;

    @Autowired
    private ModuleService moduleService;


    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index(Integer moduleId,Model model) {
        model.addAttribute("moduleId",moduleId);
        return PREFIX + "page.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String gotoAdd(Integer moduleId,Model model) {
        model.addAttribute("moduleId",moduleId);
        return PREFIX + "page_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String gotoUpdate(@PathVariable Integer id,Model model) {
        model.addAttribute("page", pageService.selectById(id));
        return PREFIX + "page_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(cn.afterturn.gen.modular.requirement.model.Page model, HttpServletRequest req, HttpServletResponse res) {
         Page<cn.afterturn.gen.modular.requirement.model.Page> page = new PageFactory<cn.afterturn.gen.modular.requirement.model.Page>().defaultPage();
        EntityWrapper<cn.afterturn.gen.modular.requirement.model.Page> wrapper = new EntityWrapper<>();
        wrapper.eq("module_id",model.getModuleId());
        page.setRecords(pageService.selectPage(page,wrapper ).getRecords());
        return super.packForBT(page);
    }


    @RequestMapping(value = "/add")
    
    @ResponseBody
    public Object add(cn.afterturn.gen.modular.requirement.model.Page model) {
        pageService.insert(model);
        return SUCCESS_TIP;
    }


    @RequestMapping(value = "/delete")
    
    @ResponseBody
    public Object delete(Integer id) {
        pageService.deleteById(id);
        return SUCCESS_TIP;
    }


    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(cn.afterturn.gen.modular.requirement.model.Page model) {
        if (ToolUtil.isOneEmpty(model.getId())) {
        throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        pageService.updateById(model);
        return SUCCESS_TIP;
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(cn.afterturn.gen.modular.requirement.model.Page model) {
        return pageService.selectById(model);
    }

    /**
     * 上传图片(上传到项目的webapp/static/img)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public void upload(@RequestPart("file") MultipartFile picture, Integer bizId) {
        if (bizId == null){
            return;
        }
        String upload = moduleService.upload(picture);
        cn.afterturn.gen.modular.requirement.model.Page page = pageService.selectById(bizId);
        if (StrUtil.isNotBlank(page.getFiles())) {
            page.setFiles(page.getFiles()+";"+upload);
        }else {
            page.setFiles(upload);
        }
        pageService.updateById(page);
    }
}