package cn.linzs.controller;

import cn.linzs.commons.ProcessResult;
import cn.linzs.entity.User;
import cn.linzs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By linzs on 7/12/17 10:48 AM
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "common/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ProcessResult validLogin(HttpServletRequest request,
                               @RequestParam(name = "account", required = false) String account,
                               @RequestParam(name = "password", required = false) String password) {
        ProcessResult result = null;

        if(account == null || password == null
                || "".equals(account) || "".equals(password)) {
            result = new ProcessResult(ProcessResult.ERROR, "账号或密码不能为空！");
        } else {
            User user = userService.findUserByAccountAndPassword(account, password);
            if(user == null) {
                result = new ProcessResult(ProcessResult.ERROR, "账号或密码错误！");
            } else {
                request.getSession(true).setAttribute("user", user);
                result = new ProcessResult(ProcessResult.SUCCESS, "验证成功！");
            }
        }

        return result;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).setAttribute("user", null);
        return "rediect:/login";
    }

}