package com.kaseya.service;

import com.kaseya.beans.User;
import com.kaseya.dao.UserDao;
import com.kaseya.models.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user != null) {
            return new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(), "ROLE_USER_2");
        }

        throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    public com.kaseya.beans.User saveUser(com.kaseya.beans.User user) {
        String originPassword = user.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(originPassword));
        return userDao.save(user);
    }


}
