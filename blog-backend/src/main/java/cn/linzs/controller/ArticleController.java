package cn.linzs.controller;

import cn.linzs.entity.Article;
import cn.linzs.entity.Article;
import cn.linzs.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created By linzs on 7/12/17 5:21 PM
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping(value = "/toArticle")
    public String toArticle() {
        return "article/list";
    }

    @RequestMapping(value = "/getArticlePage")
    @ResponseBody
    public Map<String, Object> getArticlePage(@RequestBody Map<String, Object> requestMap) {
        Map<String, Object> paramsMap = parsePageMap(requestMap);

        List<Article> articlePage = articleService.findPage(
                Integer.valueOf(paramsMap.get("pageNum").toString()),
                Integer.valueOf(paramsMap.get("pageSize").toString())
        );

        Map<String, Object> jsonMap = buildTableData(paramsMap, articlePage);
        return jsonMap;
    }

    @RequestMapping(value = "/toAddOrEdit")
    public String toAddOrEdit(@RequestParam(name = "id", required = false) Integer id, Model model) {
        Article article = null;

        if(id == null) {
            article = new Article();
        } else {
            article = articleService.findById(id);
        }

        model.addAttribute("article", article);
        return "article/addOrEdit";
    }
}
