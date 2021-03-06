package cn.linzs.service;

import cn.linzs.entity.Article;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created By linzs on 7/13/17 9:38 AM
 */
@FeignClient(value = "blog-core")
public interface IArticleService {

    @RequestMapping(value = "/article/findPage")
    List<Article> findPage(@RequestBody Map<String, Object> requestMap);

    @RequestMapping(value = "/article/findById")
    Article findById(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/article/countQuantityOfArticle")
    int countQuantityOfArticle(@RequestParam(name = "categoryId") Integer categoryId);

    @RequestMapping(value = "/article/saveArticle")
    Article saveArticle(@RequestBody Article article);

    @RequestMapping(value = "/article/delete")
    void delete(@RequestParam(name = "id") Integer id);
}
