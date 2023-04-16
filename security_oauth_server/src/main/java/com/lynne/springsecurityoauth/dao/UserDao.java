package com.lynne.springsecurityoauth.dao;

import com.lynne.springsecurityoauth.model.Permission;
import com.lynne.springsecurityoauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/4/15 6:47
 * @Author fengyongli
 **/

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByUsername(String username){
        String sql ="select id,username,password,fullname from t_user where username = ?";
        List<User> userList = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<User>(User.class));
        if (userList!=null&&userList.size()>0){
            return userList.get(0);
        }
        return null;

    }

    public List<String> findPermissionByUserId(String id){
        String sql = "SELECT * FROM t_permission WHERE id IN(\n" +
            "SELECT permission_id FROM t_role_permission WHERE role_id IN(\n" +
            "SELECT role_id FROM t_user_role WHERE user_id = ?\n" +
            ")\n" +
            ")";
        List<Permission> permissions = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Permission.class));
        final List<String> permissionList = new ArrayList<>();
        permissions.iterator().forEachRemaining(p->{
            permissionList.add(p.getCode());
        });
        return permissionList;
    }
}
