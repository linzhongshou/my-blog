package cn.linzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By linzs on 7/12/17 5:21 PM
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping("/toArticle")
    public String toArticle() {
        return "article/list";
    }
}
