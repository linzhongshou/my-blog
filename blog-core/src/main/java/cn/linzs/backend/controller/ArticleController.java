package cn.linzs.backend.controller;

import cn.linzs.backend.entity.Article;
import cn.linzs.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By linzs on 7/13/17 9:24 AM
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/findPage")
    public List<Article> findPage(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                  @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        return articleService.findPage(pageNum, pageSize);
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
