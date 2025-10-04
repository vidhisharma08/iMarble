package com.imarble.dto;

import com.imarble.entities.User.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto {
	@NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Mobile is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be 10 digits")
    private String mobile;

    @NotBlank(message = "Password is required")
    private String password;

    private Role role;

    private Boolean status;
}
