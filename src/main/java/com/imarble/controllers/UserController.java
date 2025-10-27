package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imarble.dto.UserDto;
import com.imarble.entities.User;
import com.imarble.services.UserService;
import com.imarble.dto.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create User
    @PostMapping("/adduser")
    public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody UserDto dto) {
        User user = userService.createUser(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "User created successfully", user));
    }

    // Get All Users
    @GetMapping("/allusers")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(new ApiResponse<>(true, "Users fetched successfully", users));
    }

    // Get User By ID
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "User fetched successfully", user));
    }

    // Update User
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto dto) {
        User updatedUser = userService.updateUser(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "User updated successfully", updatedUser));
    }

    // Delete User
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "User deleted successfully", null));
    }
}
