package cn.linzs.interfaces.hystrix;

import cn.linzs.interfaces.TestInterface;
import org.springframework.stereotype.Component;

/**
 * Created by root on 17-7-11.
 */
@Component
public class TestHystrix implements TestInterface {

    @Override
    public String service() {
        return "call test service occurred error!";
    }
}
