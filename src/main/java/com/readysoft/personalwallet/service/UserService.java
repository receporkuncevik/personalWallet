
package com.readysoft.personalwallet.service;


import com.readysoft.personalwallet.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> findById(Integer id);
    void save(User user);
    List<User> findAll();
}
