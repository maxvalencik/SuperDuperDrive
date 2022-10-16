package com.udacity.jwdnd.course1.cloudstorage.security;

//Imports
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.HashService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

public class AuthenticationService implements AuthenticationProvider {

    private UserMapper userMapper;
    private HashService hashService;

    public void AuthenticationService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public AuthenticationService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    @Override
    public Authentication authenticate(Authentication authentification) throws AuthenticationException {
        String userName = authentification.getName();
        String password = authentification.getCredentials().toString();

        User user = userMapper.getUser(userName);
        if (user != null) {
            String encSalt = user.getSalt();
            String hashedPassword = hashService.getHashedValue(password, encSalt);
            if (user.getPassword().equals(hashedPassword)) {
                return new UsernamePasswordAuthenticationToken(userName, password, new ArrayList<>());
            }

            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
