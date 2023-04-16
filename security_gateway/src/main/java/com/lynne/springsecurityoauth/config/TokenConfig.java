package com.lynne.springsecurityoauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description //TODO
 * @Date 2023/4/16 5:35
 * @Author fengyongli
 **/
@Configuration
public class TokenConfig {

    private static final String SIGNING_KEY = "server_signing";
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    public JwtTokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}
