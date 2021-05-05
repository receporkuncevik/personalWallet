
package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.User;
import java.util.List;


public interface UserService {
    User getUser(int id);
    void save(User user);
}
