package cn.linzs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 17-7-11.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String service() {
        return "The msg from test service.";
    }
}
