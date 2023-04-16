package com.lynne.springsecurityoauth.service;

import com.alibaba.fastjson.JSON;
import com.lynne.springsecurityoauth.dao.UserDao;
import com.lynne.springsecurityoauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/4/15 7:01
 * @Author fengyongli
 **/
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);
        List<String> permissions = userDao.findPermissionByUserId(user.getId());
        String[] pArray = new String[permissions.size()];
        permissions.toArray(pArray);
        String principal = JSON.toJSONString(user);
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(principal).password(user.getPassword()).authorities(pArray).build();
        return userDetails;
    }
}
