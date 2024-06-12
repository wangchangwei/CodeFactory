package cn.afterturn.gen.modular.requirement.controller;

import cn.afterturn.gen.common.constant.factory.PageFactory;
import cn.afterturn.gen.common.exception.BizExceptionEnum;
import cn.afterturn.gen.common.exception.BussinessException;
import cn.afterturn.gen.core.base.controller.BaseController;
import cn.afterturn.gen.core.util.ToolUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.afterturn.gen.modular.requirement.model.Module;
import cn.afterturn.gen.modular.requirement.service.ModuleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模型管理控制器
 *
 * @author 王长伟
 * @Date 2023-09-17 19:16:29
 */
@Controller
@RequestMapping("/requirement/module")
public class ModuleController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleController.class);

    private String PREFIX = "/requirement/";

    @Autowired
    private ModuleService moduleService;



    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "module.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String gotoAdd() {
        return PREFIX + "module_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String gotoUpdate(@PathVariable Integer id,Model model) {
        model.addAttribute("module", moduleService.selectById(id));
        return PREFIX + "module_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Module model,HttpServletRequest req, HttpServletResponse res) {
        Page<Module> page = new PageFactory<Module>().defaultPage();
        moduleService.selectPage(page).getRecords();
        page.setRecords(moduleService.selectPage(page).getRecords());
        return super.packForBT(page);
    }


    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Module model) {
        moduleService.insert(model);
        return SUCCESS_TIP;
    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer id) {
        moduleService.deleteById(id);
        return SUCCESS_TIP;
    }


    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Module model) {
        if (ToolUtil.isOneEmpty(model.getId())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        moduleService.updateById(model);
        return SUCCESS_TIP;
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(Module model) {
        return moduleService.selectById(model);
    }


}
            