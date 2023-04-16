package com.lynne.springsecurityoauth.model;

import lombok.Data;

/**
 * @Description //TODO
 * @Date 2023/4/15 6:45
 * @Author fengyongli
 **/
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
