package com.example.springboot.myfirstwebapp.Login;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    // building a method which will authenticate a user and redirect to welcome page only when credentials are right

    public boolean authenticate(String username,String password){
        boolean isValidUserName = username.equalsIgnoreCase("prachi");
        boolean isValidPassword = password.equalsIgnoreCase("password");

        return isValidUserName && isValidPassword;
    }
}
