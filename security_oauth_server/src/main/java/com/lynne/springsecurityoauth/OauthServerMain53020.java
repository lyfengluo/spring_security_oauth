package com.lynne.springsecurityoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description //TODO
 * @Date 2023/4/15 6:32
 * @Author fengyongli
 **/
@SpringBootApplication
@EnableEurekaClient
public class OauthServerMain53020 {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerMain53020.class,args);
    }
}
