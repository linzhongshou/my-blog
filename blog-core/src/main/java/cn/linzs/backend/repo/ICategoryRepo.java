package cn.linzs.backend.repo;

import cn.linzs.backend.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created By linzs on 7/13/17 10:35 AM
 */
public interface ICategoryRepo extends PagingAndSortingRepository<Category, Integer> {

    Category findByName(String name);
}
