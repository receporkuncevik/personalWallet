package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    User findByUserName(String userName);

}
