package cn.linzs.service;

import cn.linzs.entity.Article;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created By linzs on 7/13/17 9:38 AM
 */
@FeignClient(value = "blog-core")
public interface IArticleService {

    @RequestMapping(value = "/article/findPage")
    List<Article> findPage(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                           @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize);
}
