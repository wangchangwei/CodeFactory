package cn.afterturn.gen.modular.requirement.controller;

import cn.afterturn.gen.common.constant.factory.PageFactory;
import cn.afterturn.gen.common.exception.BizExceptionEnum;
import cn.afterturn.gen.common.exception.BussinessException;
import cn.afterturn.gen.core.base.controller.BaseController;
import cn.afterturn.gen.core.util.ToolUtil;
import cn.afterturn.gen.modular.requirement.model.Element;
import cn.afterturn.gen.modular.requirement.service.ElementService;
import cn.afterturn.gen.modular.requirement.service.PageService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 元素管理控制器
 *
 * @author 王长伟
 * @Date 2023-09-18 19:44:46
 */
@Controller
@RequestMapping("requirement/element")
public class ElementController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElementController.class);

    private String PREFIX = "/requirement/";

    @Autowired
    private ElementService elementService;

    @Resource
    private PageService pageService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index(Integer pageId,Model model) {
        model.addAttribute("pageId",pageId);
        return PREFIX + "element.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String gotoAdd(Integer pageId,Model model) {
        model.addAttribute("pageId",pageId);
        return PREFIX + "element_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String gotoUpdate(@PathVariable Integer id,Model model) {
        model.addAttribute("element", elementService.selectById(id));
        return PREFIX + "element_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Element model,HttpServletRequest req, HttpServletResponse res) {
        Page<Element> page = new PageFactory<Element>().defaultPage();
        EntityWrapper<Element> wrapper = new EntityWrapper<>();
        wrapper.eq("page_id",model.getPageId());
        page.setRecords(elementService.selectPage(page,wrapper).getRecords());
        return super.packForBT(page);
    }


    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Element model) {
        Integer moduleId = pageService.selectById(model.getPageId()).getModuleId();
        model.setModuleId(moduleId);
        elementService.insert(model);
        return SUCCESS_TIP;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer id) {
        elementService.deleteById(id);
        return SUCCESS_TIP;
    }


    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Element element) {
        if (ToolUtil.isOneEmpty(element.getId())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        elementService.updateById(element);
        return SUCCESS_TIP;
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(Element model) {
        return elementService.selectById(model);
    }
}