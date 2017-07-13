package cn.linzs.backend.service;

import cn.linzs.backend.entity.Category;
import cn.linzs.backend.repo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Pageable pageable = new PageRequest(pageNum, pageSize);
        return categoryRepo.findAll(pageable).getContent();
    }
}
