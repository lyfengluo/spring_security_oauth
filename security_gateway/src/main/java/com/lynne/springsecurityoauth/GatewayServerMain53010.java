package com.lynne.springsecurityoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description //TODO
 * @Date 2023/4/15 10:34
 * @Author fengyongli
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayServerMain53010 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerMain53010.class,args);
    }
}
