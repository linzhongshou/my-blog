package cn.linzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By linzs on 7/12/17 3:27 PM
 */
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/404")
    public String to404() {
        return "common/404";
    }

    @RequestMapping(value = "/500")
    public String to500() {
        return "common/500";
    }
}
