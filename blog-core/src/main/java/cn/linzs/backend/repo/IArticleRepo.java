package cn.linzs.backend.repo;

import cn.linzs.backend.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By linzs on 7/13/17 9:24 AM
 */
@Repository
public interface IArticleRepo extends PagingAndSortingRepository<Article, Integer> {
}
