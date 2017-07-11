package cn.linzs.interfaces;

import cn.linzs.interfaces.hystrix.TestHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by root on 17-7-11.
 */
@FeignClient(value = "blog-core", fallback = TestHystrix.class)
public interface TestInterface {

    @RequestMapping(value = "test/service", method = RequestMethod.GET)
    String service();
}
