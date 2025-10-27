package com.imarble.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imarble.dto.ApiResponse;
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

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody Map<String, String> req) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.get("mobile"), req.get("password"))
            );
        } catch (org.springframework.security.core.AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse<>(false, "Invalid credentials", null));
        }

        var userDetails = userDetailsService.loadUserByUsername(req.get("mobile"));
        String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new ApiResponse<>(true, "Login successful", token));
    }

}
