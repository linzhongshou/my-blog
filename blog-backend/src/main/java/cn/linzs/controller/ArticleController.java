package cn.linzs.controller;

import cn.linzs.commons.ProcessResult;
import cn.linzs.commons.utils.BeanUtils;
import cn.linzs.entity.Article;
import cn.linzs.entity.Article;
import cn.linzs.entity.Category;
import cn.linzs.service.IArticleService;
import cn.linzs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @Autowired
    private ICategoryService categoryService;

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
        model.addAttribute("categoryList", categoryService.getAllCategory());
        return "article/addOrEdit";
    }

    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    @ResponseBody
    public ProcessResult saveArticle(Article article) {
        ProcessResult result = null;

        try {
            if(article.getId() == null) {
                article.setCreateDate(new Date());
            } else {
                Article old = articleService.findById(article.getId());
                article.setUpdateDate(new Date());

                BeanUtils.copyProperties(article, old);
                old.setAllowComment(article.getAllowComment());
                old.setAllowThumbup(article.getAllowThumbup());
                old.setVisible(article.getVisible());

                article = old;
            }

            articleService.saveArticle(article);
            result = new ProcessResult(ProcessResult.SUCCESS, "保存成功！");
        } catch(Exception e) {
            result = new ProcessResult(ProcessResult.EXCEPTION, "发生异常，异常信息：" + e.getLocalizedMessage());
        }

        return result;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ProcessResult delete(Integer id) {
        ProcessResult result = null;

        try {
            articleService.delete(id);
            result = new ProcessResult(ProcessResult.SUCCESS, "删除成功！");
        } catch(Exception e) {
            result = new ProcessResult(ProcessResult.EXCEPTION, "发生异常，异常信息：" + e.getLocalizedMessage());
        }

        return result;
    }
}
