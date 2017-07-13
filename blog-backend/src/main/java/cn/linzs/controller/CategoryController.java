package cn.linzs.controller;

import cn.linzs.entity.Category;
import cn.linzs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
