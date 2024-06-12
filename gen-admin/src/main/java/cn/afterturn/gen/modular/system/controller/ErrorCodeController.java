package cn.afterturn.gen.modular.system.controller;

import cn.afterturn.gen.common.annotion.BussinessLog;
import cn.afterturn.gen.common.annotion.Permission;
import cn.afterturn.gen.common.constant.factory.PageFactory;
import cn.afterturn.gen.common.exception.BizExceptionEnum;
import cn.afterturn.gen.common.exception.BussinessException;
import cn.afterturn.gen.core.base.controller.BaseController;
import cn.afterturn.gen.core.util.ToolUtil;
import cn.afterturn.gen.modular.system.model.ErrorCodeModel;
import cn.afterturn.gen.modular.system.service.IErrorCodeService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * 控制器
 *
 * @author David
 * @Date 2023-01-30 10:26
 */
@Controller
@RequestMapping("/errorcode")
public class ErrorCodeController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorCodeController.class);

    private String PREFIX = "/system/error_code/";

    @Autowired
    private IErrorCodeService errorCodeService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "errorcode.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String ErrorCodeAdd() {
        return PREFIX + "errorcode_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String ErrorCodeUpdate(@PathVariable Integer id, Model model) {
	model.addAttribute("errorcode", errorCodeService.selectById(id));
        return PREFIX + "errorcode_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(ErrorCodeModel model) {
        Page<ErrorCodeModel> page = new PageFactory<ErrorCodeModel>().defaultPage();
        EntityWrapper<ErrorCodeModel> entityWrapper = new EntityWrapper<>();
        entityWrapper.like("cn_text",model.getCnText()).or().like("en_text",model.getEnText());
        page.setRecords(errorCodeService.selectPage(page,model,entityWrapper));
        return super.packForBT(page);
    }


    @BussinessLog(value = "新增", key = "ErrorCodeModel" )
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ErrorCodeModel model) {
        Integer max = errorCodeService.selectMax(model.getCodeType());
        model.setCode(max+1);
        errorCodeService.insert(model);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "删除", key = "id" )
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer id) {
        errorCodeService.deleteById(id);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "修改", key = "id" )
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ErrorCodeModel model) {
        if (ToolUtil.isOneEmpty(model.getId())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        errorCodeService.updateById(model);
        return super.SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(ErrorCodeModel model) {
        return errorCodeService.selectOne(model);
    }

    /**
     * 导出
     * */
    @RequestMapping(value = "/export")
    @ResponseBody
    public Object export(HttpServletRequest request){
        List<ErrorCodeModel> errorCodeModels = errorCodeService.selectList(new ErrorCodeModel());
        StringBuilder builder=new StringBuilder();
        for (ErrorCodeModel errorCodeModel : errorCodeModels) {
            builder.append(errorCodeModel.getEnText()+"="+errorCodeModel.getCnText()+"\n");
        }
        byte[] data=builder.toString().getBytes();
        HttpHeaders headers = new HttpHeaders();
        String prefix=System.currentTimeMillis()+"";
        try {
            String agent = request.getHeader("USER-AGENT");
            boolean isIE = null != agent, isMC = null != agent;
            isIE = isIE && (agent.indexOf("MSIE") != -1 || agent.indexOf("Trident") != -1);
            isMC = isMC && (agent.indexOf("Mozilla") != -1);
            prefix = isMC ? new String(prefix.getBytes("UTF-8"), "iso-8859-1") :
                    (isIE ? java.net.URLEncoder.encode(prefix, "UTF8") : prefix);
            headers.setContentDispositionFormData("attachment", prefix + ".txt" );
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }
}
