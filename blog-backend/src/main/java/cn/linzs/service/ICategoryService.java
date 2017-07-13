package cn.linzs.service;

import cn.linzs.entity.Category;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created By linzs on 7/13/17 10:41 AM
 */
@FeignClient(value = "blog-core")
public interface ICategoryService {

    @RequestMapping(value = "/category/findPage")
    List<Category> findPage(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize);

    @RequestMapping(value = "/category/findById")
    Category findById(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/category/findByName")
    Category findByName(@RequestParam(name = "name") String name);

    @RequestMapping(value = "/category/saveCategory")
    Category saveCategory(@RequestBody Category category);

    @RequestMapping(value = "/category/delete")
    void delete(@RequestParam(name = "id") Integer id);
}
