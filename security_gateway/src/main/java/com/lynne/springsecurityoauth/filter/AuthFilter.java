package com.lynne.springsecurityoauth.filter;

import com.alibaba.fastjson.JSON;
import com.lynne.springsecurityoauth.common.EncryptUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description //TODO
 * @Date 2023/4/16 6:43
 * @Author fengyongli
 **/
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
            return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof OAuth2Authentication)){
            return null;
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
        //获取用户信息
        String principal = userAuthentication.getName();
        //取出用户权限
        List<String> authorities = new ArrayList<>();
        userAuthentication.getAuthorities().stream().forEach(c->{
            authorities.add(((GrantedAuthority) c).getAuthority());
        });
        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
        Map<String, String> refreshTokenRequest = oAuth2Request.getRequestParameters();
        Map<String,Object> jsonToken = new HashMap<>(refreshTokenRequest);
        if(userAuthentication!=null){
            jsonToken.put("principal",principal);
            jsonToken.put("authorities",authorities);
        }
        context.addZuulRequestHeader("json-token", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)));
        return null;
    }
}
