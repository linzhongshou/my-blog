package cn.linzs.repo;

import cn.linzs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By linzs on 7/12/17 11:52 AM
 */
@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

    User findUserByAccountAndPassword(String account, String password);
}
