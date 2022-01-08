package com.pe.stmp.one.meetcongressoauth;

import com.pe.stmp.one.meetcongressoauth.models.UserResponse;
import com.pe.stmp.one.meetcongressoauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdditionalToken implements TokenEnhancer {

    @Autowired
    private UserService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();

        UserResponse user = userService.findByUsername(oAuth2Authentication.getName());

        info.put("firstname", user.getFirstName());
        info.put("lastname", user.getLastName());
        info.put("email", user.getEmail());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        return oAuth2AccessToken;
    }
}
