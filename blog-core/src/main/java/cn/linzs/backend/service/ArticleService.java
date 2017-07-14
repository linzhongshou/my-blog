package cn.linzs.backend.service;

import cn.linzs.backend.entity.Article;
import cn.linzs.backend.entity.Category;
import cn.linzs.backend.repo.IArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created By linzs on 7/13/17 9:25 AM
 */
@Service
@Transactional
public class ArticleService {

    @Autowired
    private IArticleRepo articleRepo;

    public List<Article> findPage(int pageNum, int pageSize) {
        Pageable pageable = new PageRequest(pageNum, pageSize);
        return articleRepo.findAll(pageable).getContent();
    }

    public Article findById(Integer id) {
        return articleRepo.findOne(id);
    }

    public int countByCategoryId(Integer categoryId) {
        return articleRepo.countByCategoryId(categoryId);
    }

    public Article save(Article article) {
        return articleRepo.save(article);
    }

    public void delte(Integer id) {
        articleRepo.delete(id);
    }

}
