package com.jorgealvarez.myboda.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AttendantService {

    public static String getLoggedUserService() {

        String currentPrincipalName;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return currentPrincipalName = authentication.getName();
    }

    public static boolean isAdmin() {
        boolean isAdmin = false;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            isAdmin = true;
        }
        return isAdmin;
    }
}


