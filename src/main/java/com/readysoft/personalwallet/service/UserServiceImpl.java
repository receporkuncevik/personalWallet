
package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.repository.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    
    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepo.getOne(id);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

}
