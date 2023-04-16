package com.lynne.springsecurityoauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description //TODO
 * @Date 2023/4/16 5:29
 * @Author fengyongli
 **/
@Configuration
public class ResourceServerConfig {

    private String RESOURCE_ID = "res1";

    //oauthServer 资源服务配置
    @Configuration
    @EnableResourceServer
   public class OauthServerConfig extends ResourceServerConfigurerAdapter{

        @Autowired
        private JwtTokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/oauthServer/**")
                    .permitAll();
        }
    }

    @Configuration
    @EnableResourceServer
    public class OrderServerConfig extends ResourceServerConfigurerAdapter{

        @Autowired
        private JwtTokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/orderServer/**").access("#oauth2.hasAnyScope( 'ROLE_ADMIN','ROLE_USER','ROLE_API')");
        }
    }
}
