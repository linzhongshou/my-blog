package cn.linzs.service;

import cn.linzs.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By linzs on 7/12/17 12:01 PM
 */
@FeignClient(value = "blog-core")
public interface IUserService {

    @RequestMapping(value = "/user/findUserByAccountAndPassword", method = RequestMethod.GET)
    User findUserByAccountAndPassword(@RequestParam(name = "account", required = false) String account,
                                      @RequestParam(name = "password", required = false) String password);
}
