package com.imarble.mapper;

import com.imarble.dto.UserDto;
import com.imarble.entities.User;

public class UserMapper {

    public static User toEntity(UserDto dto) {
        return User.builder()
                .name(dto.getName())
                .mobile(dto.getMobile())
                .password(dto.getPassword())
                .role(dto.getRole())
                .status(dto.getStatus())
                .build();
    }

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setMobile(user.getMobile());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setStatus(user.getStatus());
        return dto;
    }
}
