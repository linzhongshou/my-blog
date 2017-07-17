package cn.linzs.repo;

import cn.linzs.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By linzs on 7/13/17 9:24 AM
 */
@Repository
public interface IArticleRepo extends JpaSpecificationExecutor<Article>, PagingAndSortingRepository<Article, Integer> {

    int countByCategoryId(Integer categoryId);
}
