package cn.linzs.controller;

import cn.linzs.interfaces.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 17-7-11.
 */
@RestController
public class TestController {

    @Autowired
    public TestInterface testService;

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String service() {
        return testService.service();
    }
}
