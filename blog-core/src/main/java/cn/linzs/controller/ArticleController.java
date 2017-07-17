package cn.linzs.controller;

import cn.linzs.entity.Article;
import cn.linzs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created By linzs on 7/13/17 9:24 AM
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/findPage")
    public List<Article> findPage(@RequestBody Map<String, Object> requestMap) {
        return articleService.findPage(requestMap);
    }

    @RequestMapping(value = "/findById")
    public Article findById(@RequestParam(name = "id") Integer id) {
        return articleService.findById(id);
    }

    @RequestMapping(value = "/countQuantityOfArticle")
    public int countQuantityOfArticle(@RequestParam(name = "categoryId") Integer categoryId) {
        return articleService.countByCategoryId(categoryId);
    }

    @RequestMapping(value = "/saveArticle")
    public Article saveArticle(@RequestBody Article article) {
        return articleService.save(article);
    }

    @RequestMapping(value = "/delete")
    public void delete(@RequestParam(name = "id") Integer id) {
        articleService.delte(id);
    }
}
