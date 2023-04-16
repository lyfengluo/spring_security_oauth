package com.lynne.springsecurityoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description //TODO
 * @Date 2023/4/14 9:12
 * @Author fengyongli
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain.class,args);
    }
}
