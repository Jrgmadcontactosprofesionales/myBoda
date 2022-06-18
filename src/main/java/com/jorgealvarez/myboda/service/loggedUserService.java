package com.jorgealvarez.myboda.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class loggedUserService {

    public static String getLoggedUserService() {

    String currentPrincipalName;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return currentPrincipalName = authentication.getName();
}

}

