package com.imarble.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
