package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("Kullanıcı Bulunamadı");
        }
        return new CustomUserDetail(user);
    }
}
