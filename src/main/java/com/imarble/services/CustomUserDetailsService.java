package com.imarble.services;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.imarble.entities.User;
import com.imarble.repos.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	  private final UserRepository userRepo;

	    public CustomUserDetailsService(UserRepository userRepo) {
	        this.userRepo = userRepo;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
	        User user = userRepo.findByMobile(mobile)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

	        if (!user.getStatus()) {
	            throw new UsernameNotFoundException("User not approved yet");
	        }

	        return org.springframework.security.core.userdetails.User
	                .withUsername(user.getMobile())
	                .password(user.getPassword())
	                .roles(user.getRole().name())
	                .build();
	    }
}
