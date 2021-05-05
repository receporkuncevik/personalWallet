
package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.repository.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public User getUser(int id) {
        return userRepo.getOne(id);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

}
