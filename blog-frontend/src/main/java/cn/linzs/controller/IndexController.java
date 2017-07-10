package cn.linzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 17-7-5.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String toIndex() {
        return "redirect:/www/index.html";
    }

    @RequestMapping("/404")
    public String process404() {
        return "redirect:/www/index.html";
    }

}
