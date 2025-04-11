package com.example.Blog_Project.Oauth;

import lombok.Getter;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Getter
public class CustomOAuth2User extends DefaultOAuth2User {
    private final String email;
    private final String name;

    public CustomOAuth2User(OAuth2User user) {
        super(user.getAuthorities(), user.getAttributes(), "sub");
        this.email = user.getAttribute("email");
        this.name = user.getAttribute("name");
    }

}