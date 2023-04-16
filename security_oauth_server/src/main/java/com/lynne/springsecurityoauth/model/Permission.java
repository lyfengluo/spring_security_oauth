package com.lynne.springsecurityoauth.model;

import lombok.Data;

/**
 * @Description //TODO
 * @Date 2023/4/15 6:46
 * @Author fengyongli
 **/
@Data
public class Permission {
    private String id;
    private String code;
    private String description;
    private String url;
}
