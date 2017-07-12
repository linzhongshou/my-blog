package cn.linzs.backend.controller;

import cn.linzs.backend.entity.User;
import cn.linzs.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By linzs on 7/12/17 11:55 AM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findUserByAccountAndPassword")
    public User findUserByAccountAndPassword(@RequestParam(name = "account", required = false) String account,
                                             @RequestParam(name = "password", required = false) String password) {
        return userService.findUserByAccountAndPassword(account, password);
    }
}
