package cn.linzs.backend.controller;

import cn.linzs.backend.entity.Category;
import cn.linzs.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created By linzs on 7/13/17 10:39 AM
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/findPage")
    public List<Category> findPage(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return categoryService.findPage(pageNum, pageSize);
    }

    @RequestMapping(value = "/findById")
    public Category findById(@RequestParam(name = "id") Integer id) {
        return categoryService.findById(id);
    }

    @RequestMapping(value = "/getAllCategory")
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/findByName")
    public Category findByName(@RequestParam(name = "name") String name) {
        return categoryService.findByName(name);
    }

    @RequestMapping(value = "/saveCategory")
    public Category saveCategory(@RequestBody Category category) {
        return  categoryService.saveCategory(category);
    }

    @RequestMapping(value = "/delete")
    public void delete(@RequestParam(name = "id") Integer id) {
        categoryService.delete(id);
    }
}
