package com.imarble.controllers;

import java.util.Map;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imarble.entities.User;
import com.imarble.services.CustomUserDetailsService;
import com.imarble.services.UserService;
import com.imarble.utils.JwtUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService userDetailsService;
    private final UserService userService;

    public AuthController(AuthenticationManager authManager,
                          JwtUtils jwtUtils,
                          CustomUserDetailsService userDetailsService,
                          UserService userService) {
        this.authManager = authManager;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> req) {
        User user = userService.registerUser(
                req.get("name"),
                req.get("mobile"),
                req.get("password"),
                User.Role.valueOf(req.get("role").toUpperCase())
        );
        return ResponseEntity.ok(Map.of("message", "Registration successful. Awaiting admin approval."));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.get("mobile"), req.get("password"))
            );
        } catch (org.springframework.security.core.AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
        }

        var userDetails = userDetailsService.loadUserByUsername(req.get("mobile"));
        String token = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(Map.of("token", token));
    }

    // Admin-only endpoints
    @GetMapping("/pending")
    public ResponseEntity<?> pendingUsers() {
        return ResponseEntity.ok(userService.getPendingUsers());
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<?> approveUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.approveUser(id));
    }
}
