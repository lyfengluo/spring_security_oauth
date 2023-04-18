package com.lynne.springsecurityoauth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description //TODO
 * @Date 2023/4/15 6:46
 * @Author fengyongli
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private String id;
    private String code;
    private String description;
    private String url;
}
