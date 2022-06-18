package com.jorgealvarez.myboda.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import  com.jorgealvarez.myboda.model.User;
import  com.jorgealvarez.myboda.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
