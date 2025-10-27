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
    private UserRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ Create user (admin adds user)
    public User createUser(UserDto dto) {
        if (userRepo.findByMobile(dto.getMobile()).isPresent()) {
            throw new RuntimeException("Mobile number already exists");
        }

        User user = UserMapper.toEntity(dto);
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // If not provided, set status to true by default
        if (user.getStatus() == null) user.setStatus(true);
        return userRepo.save(user);
    }

    // ✅ Get all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // ✅ Get user by ID
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // ✅ Update user
    public User updateUser(Long id, UserDto dto) {
        User existing = getUserById(id);
        existing.setName(dto.getName());
        existing.setMobile(dto.getMobile());
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(dto.getPassword())); // Encode password
        }
        existing.setRole(dto.getRole());
        existing.setStatus(dto.getStatus());
        return userRepo.save(existing);
    }

    // ✅ Delete user
    public void deleteUser(Long id) {
        User existing = getUserById(id);
        userRepo.delete(existing);
    }

    // ✅ Get user by mobile (used for login)
    public User getUserByMobile(String mobile) {
        return userRepo.findByMobile(mobile)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Optional: for future use if you want pending users (currently all users are active)
    public List<User> getPendingUsers() {
        return userRepo.findAll().stream()
                .filter(u -> u.getStatus() != null && !u.getStatus())
                .toList();
    }

    // Optional: approve user (if you want to use in future)
    public User approveUser(Long id) {
        User user = getUserById(id);
        user.setStatus(true);
        return userRepo.save(user);
    }
}
