package com.practive.course.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practive.course.model.Credentials;
import com.practive.course.repository.CredentialsRepository;

@Service
public class UsersDetailsImpl implements UserDetailsService {
	@Autowired CredentialsRepository credentialRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credentials credential=credentialRepo.findUserDetails(username);
		GrantedAuthority authority=new SimpleGrantedAuthority(credential.getRoles().toString());
		User user=new User(username,credential.getPassword(),Arrays.asList(authority));
		return (UserDetails)user;
	}

}
