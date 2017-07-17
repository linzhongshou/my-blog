package cn.linzs.service;

import cn.linzs.entity.User;
import cn.linzs.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created By linzs on 7/12/17 11:51 AM
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private IUserRepo userRepo;

    public User findUserByAccountAndPassword(String account, String password) {
        return userRepo.findUserByAccountAndPassword(account, password);
    }
}
