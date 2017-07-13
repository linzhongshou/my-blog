package cn.linzs.controller;

import cn.linzs.commons.ProcessResult;
import cn.linzs.commons.utils.BeanUtils;
import cn.linzs.entity.Category;
import cn.linzs.service.IArticleService;
import cn.linzs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created By linzs on 7/13/17 10:43 AM
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IArticleService articleService;

    @RequestMapping(value = "/toCategory")
    public String toCategory() {
        return "category/list";
    }

    @RequestMapping(value = "/getCategoryPage")
    @ResponseBody
    public Map<String, Object> getCategoryPage(@RequestBody Map<String, Object> requestMap) {
        Map<String, Object> paramsMap = parsePageMap(requestMap);

        List<Category> categoryPage = categoryService.findPage(
                Integer.valueOf(paramsMap.get("pageNum").toString()),
                Integer.valueOf(paramsMap.get("pageSize").toString())
        );

        Map<String, Object> jsonMap = buildTableData(paramsMap, categoryPage);
        return jsonMap;
    }

    @RequestMapping(value = "/toAddOrEdit")
    public String toAddOrEdit(@RequestParam(name = "id", required = false) Integer id, Model model) {
        Category category = null;

        if(id == null) {
            category = new Category();
        } else {
            category = categoryService.findById(id);
        }

        model.addAttribute("category", category);
        return "category/addOrEdit";
    }

    @RequestMapping(value = "/saveCategory")
    @ResponseBody
    public ProcessResult saveCategory(Category category) {
        ProcessResult result = null;

        try {
            Category temp = categoryService.findByName(category.getName());
            if(temp != null && !temp.getId().equals(category.getId())) {
                result = new ProcessResult(ProcessResult.ERROR, "分类名["+category.getName()+"]已存在！");
            } else {
                if(category.getId() == null) {
                    category.setCreateDate(new Date());
                } else {
                    Category old = categoryService.findById(category.getId());
                    category.setUpdateDate(new Date());

                    BeanUtils.copyProperties(category, old);
                    category = old;
                }

                categoryService.saveCategory(category);
                result = new ProcessResult(ProcessResult.SUCCESS, "保存成功！");
            }
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
            int count = articleService.countQuantityOfArticle(id);
            if(count > 0) {
                result = new ProcessResult(ProcessResult.ERROR, "该分类下有博客文章引用，无法删除！");
            } else {
                categoryService.delete(id);
                result = new ProcessResult(ProcessResult.SUCCESS, "删除成功！");
            }
        } catch(Exception e) {
            result = new ProcessResult(ProcessResult.EXCEPTION, "发生异常，异常信息：" + e.getLocalizedMessage());
        }

        return result;
    }
}
