package cn.linzs.service;

import cn.linzs.entity.Category;
import cn.linzs.repo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created By linzs on 7/13/17 10:38 AM
 */
@Service
@Transactional
public class CategoryService {

    @Autowired
    private ICategoryRepo categoryRepo;

    public List<Category> findPage(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "sort");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        return categoryRepo.findAll(pageable).getContent();
    }

    public Category findById(Integer id) {
        return categoryRepo.findOne(id);
    }

    public List<Category> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC, "sort");
        return (List<Category>) categoryRepo.findAll(sort);
    }

    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void delete(Integer id) {
        categoryRepo.delete(id);
    }
}
