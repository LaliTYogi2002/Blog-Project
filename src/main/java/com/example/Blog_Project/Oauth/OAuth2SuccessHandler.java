package com.example.Blog_Project.Oauth;

import com.example.Blog_Project.Enum.RoleStatusEnum;
import com.example.Blog_Project.Enum.UserStatusEnum;
import com.example.Blog_Project.Jwt.JwtTokenProvider;
import com.example.Blog_Project.Model.Role;
import com.example.Blog_Project.Model.User;
import com.example.Blog_Project.Repository.RoleRepository;
import com.example.Blog_Project.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        Optional<User> existingUser = userRepository.findByEmail(email);

        User user;
        if (existingUser.isPresent()) {
            user = existingUser.get();
        } else {
            // 🔐 Assign default role "ROLE_USER"
            Role role = roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new RuntimeException("Role not found"));

            // 🔐 Register new user
            user = User.builder()
                    .email(email)
                    .name(name)
                    .password("OAUTH2_USER") // dummy password
                    .status(UserStatusEnum.ACTIVE)
                    .role(role)
                    .build();

//            user.setRole(role);


            userRepository.save(user);
        }

        String token = tokenProvider.generateToken(user.getEmail(), user.getName(), user.getRole().getName());

//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("{\"token\": \"" + token + "\"}");

// Redirect to frontend with token as query param
        String redirectUrl = "http://localhost:4200?token=" + URLEncoder.encode(token, StandardCharsets.UTF_8);

        response.sendRedirect(redirectUrl);

    }
}
