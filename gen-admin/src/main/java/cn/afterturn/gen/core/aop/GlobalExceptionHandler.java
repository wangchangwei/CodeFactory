package cn.afterturn.gen.core.aop;

import cn.afterturn.gen.common.exception.BizExceptionEnum;
import cn.afterturn.gen.common.exception.BussinessException;
import cn.afterturn.gen.common.exception.InvalidKaptchaException;
import cn.afterturn.gen.core.base.tips.ErrorTip;
import cn.afterturn.gen.core.log.LogManager;
import cn.afterturn.gen.core.log.factory.LogTaskFactory;
import cn.afterturn.gen.core.shiro.ShiroKit;
import cn.afterturn.gen.core.support.HttpKit;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.UnknownSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午3:19:56
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     *
     * @author fengshuonan
     */
    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorTip notFount(BussinessException e) {
        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        HttpKit.getRequest().setAttribute("tip", e.getMessage());
        log.error("业务异常:", e);
        return new ErrorTip(e.getCode(), e.getMessage());
    }

    /**
     * 用户未登录
     *
     * @author fengshuonan
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unAuth(AuthenticationException e) {
        log.error("用户未登陆：", e);
        return "/login.html";
    }

    /**
     * 账号被冻结
     *
     * @author fengshuonan
     */
    @ExceptionHandler(DisabledAccountException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String accountLocked(DisabledAccountException e, Model model) {
        String username = HttpKit.getRequest().getParameter("username");
        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "账号被冻结", HttpKit.getIp()));
        model.addAttribute("tips", "账号被冻结");
        return "/login.html";
    }

    /**
     * 账号密码错误
     *
     * @author fengshuonan
     */
    @ExceptionHandler(CredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String credentials(CredentialsException e, Model model) {
        String username = HttpKit.getRequest().getParameter("username");
        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "账号密码错误", HttpKit.getIp()));
        model.addAttribute("tips", "账号密码错误");
        return "/login.html";
    }

    /**
     * 验证码错误
     *
     * @author fengshuonan
     */
    @ExceptionHandler(InvalidKaptchaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String credentials(InvalidKaptchaException e, Model model) {
        String username = HttpKit.getRequest().getParameter("username");
        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "验证码错误", HttpKit.getIp()));
        model.addAttribute("tips", "验证码错误");
        return "/login.html";
    }

    /**
     * 注册相关错误
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(UnknownAccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String register(UnknownAccountException e, Model model) {
        model.addAttribute("tips", e.getMessage());
        return "/register.html";
    }

    /**
     * 无权访问该资源
     *
     * @author fengshuonan
     */
    @ExceptionHandler(UndeclaredThrowableException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorTip credentials(UndeclaredThrowableException e) {
        HttpKit.getRequest().setAttribute("tip", "权限异常");
        log.error("权限异常!", e);
        return new ErrorTip(BizExceptionEnum.NO_PERMITION.getCode(), BizExceptionEnum.NO_PERMITION.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     *
     * @author fengshuonan
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String notFount(RuntimeException e) {
        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        HttpKit.getRequest().setAttribute("tip", "服务器未知运行时异常");
        log.error("运行时异常:", e);
        return "/500.html";
        //return new ErrorTip(BizExceptionEnum.SERVER_ERROR.getCode(), BizExceptionEnum.SERVER_ERROR.getMessage());
    }

    /**
     * session失效的异常拦截
     *
     * @author stylefeng
     * @Date 2017/6/7 21:02
     */
    @ExceptionHandler(InvalidSessionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String sessionTimeout(InvalidSessionException e, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("tips", "session超时");
        assertAjax(request, response);
        return "/login.html";
    }

    /**
     * session异常
     *
     * @author stylefeng
     * @Date 2017/6/7 21:02
     */
    @ExceptionHandler(UnknownSessionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String sessionTimeout(UnknownSessionException e, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("tips", "session超时");
        assertAjax(request, response);
        return "/login.html";
    }

    private void assertAjax(HttpServletRequest request, HttpServletResponse response) {
        if (request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            //如果是ajax请求响应头会有，x-requested-with
            response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
        }
    }

}
