package com.arasu.bar.bar.application.controller.token;

import com.arasu.bar.bar.application.authentication.JwtTokenUtil;
import com.arasu.bar.bar.application.controller.user.UserService;
import com.arasu.bar.bar.application.entities.User;
import com.arasu.bar.bar.application.model.AuthToken;
import com.arasu.bar.bar.application.model.Login;
import com.arasu.bar.bar.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

//    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    String hashedPassword = passwordEncoder.encode(login.getPassword());

    public AuthToken getToken(Login login) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUserEmail(), login.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findOne(login.getUserEmail());
        final String token = jwtTokenUtil.generateToken(user);
        return new AuthToken(token);
    }
    public String getToken(String userEmail, String password) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userEmail, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findOne(userEmail);
        final String token = jwtTokenUtil.generateToken(user);
        return token;
    }


}

