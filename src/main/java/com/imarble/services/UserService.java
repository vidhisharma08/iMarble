package com.imarble.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.imarble.dto.UserDto;
import com.imarble.entities.User;
import com.imarble.mapper.UserMapper;
import com.imarble.repos.UserRepository;

@Service
public class UserService {

	 @Autowired
	    private UserRepository userRepository;


	    public User createUser(UserDto dto) {
	        if (userRepository.findByMobile(dto.getMobile()).isPresent()) {
	            throw new RuntimeException("Mobile number already exists");
	        }
	        User user = UserMapper.toEntity(dto);
	        return userRepository.save(user);
	    }

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public User getUserById(Long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
	    }

	    public User updateUser(Long id, UserDto dto) {
	        User existing = getUserById(id);
	        existing.setName(dto.getName());
	        existing.setMobile(dto.getMobile());
	        existing.setPassword(dto.getPassword());
	        existing.setRole(dto.getRole());
	        existing.setStatus(dto.getStatus());
	        return userRepository.save(existing);
	    }

	    public void deleteUser(Long id) {
	        User existing = getUserById(id);
	        userRepository.delete(existing);
	    }
	    
	    private final UserRepository userRepo;
	    private final BCryptPasswordEncoder passwordEncoder;

	    public UserService(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
	        this.userRepo = userRepo;
	        this.passwordEncoder = passwordEncoder;
	    }

	    // Register new user
	    public User registerUser(String name, String mobile, String password, User.Role role) {
	        if (userRepo.existsByMobile(mobile)) {
	            throw new RuntimeException("Mobile already registered!");
	        }

	        User user = User.builder()
	                .name(name)
	                .mobile(mobile)
	                .password(passwordEncoder.encode(password))  // ✅ encode password
	                .role(role)
	                .status(false)  // pending approval
	                .build();

	        return userRepo.save(user);
	    }

	    // Get all pending users (for admin approval)
	    public List<User> getPendingUsers() {
	        return userRepo.findAll().stream()
	                .filter(u -> !u.getStatus())
	                .toList();
	    }

	    // Approve user
	    public User approveUser(Long id) {
	        User user = userRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        user.setStatus(true);
	        return userRepo.save(user);
	    }
}
