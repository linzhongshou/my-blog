package cn.linzs.service;

import cn.linzs.entity.Article;
import cn.linzs.repo.IArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created By linzs on 7/13/17 9:25 AM
 */
@Service
@Transactional
public class ArticleService {

    @Autowired
    private IArticleRepo articleRepo;

    public List<Article> findPage(Map<String, Object> paramsMap) {

        Pageable pageable = new PageRequest(Integer.valueOf(paramsMap.get("pageNum").toString()),
                                             Integer.valueOf(paramsMap.get("pageSize").toString()));

        Specification specification = new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if(paramsMap.get("categoryId") != null) {
                    Path<Integer> categoryId = root.get("categoryId");
                    criteriaQuery.where(criteriaBuilder.equal(categoryId, paramsMap.get("categoryId")));
                }

                return null;
            }
        };

        return articleRepo.findAll(specification, pageable).getContent();
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
