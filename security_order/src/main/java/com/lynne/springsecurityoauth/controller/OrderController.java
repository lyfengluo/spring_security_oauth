package com.lynne.springsecurityoauth.controller;

import com.lynne.springsecurityoauth.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Date 2023/4/16 6:09
 * @Author fengyongli
 **/
@RestController
public class OrderController {
    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getFullname()+"访问资源1";
    }


}
