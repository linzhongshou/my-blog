package cn.linzs.controller;

import cn.linzs.entity.Article;
import cn.linzs.entity.Category;
import cn.linzs.service.IArticleService;
import cn.linzs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by root on 17-7-6.
 */
@RestController
@RequestMapping("/blog")
public class BlogController extends BaseController {

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/page")
    public Map<String, Object> page(@RequestBody Map<String, Object> requestMap) {
        Map<String, Object> paramsMap = parsePageMap(requestMap);
        List<Article> articlePage = articleService.findPage(paramsMap);
        Map<String, Object> jsonMap = buildTableData(paramsMap, articlePage);
        return jsonMap;
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryService.getAllCategory();
    }

    @RequestMapping(value = "/getPost", method = RequestMethod.GET)
    public Article getPost(@RequestParam(name = "id") Integer id) {
        return  articleService.findById(id);
    }
}
