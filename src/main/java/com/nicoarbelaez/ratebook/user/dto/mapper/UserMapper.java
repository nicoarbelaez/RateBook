package com.nicoarbelaez.ratebook.user.dto.mapper;

import com.nicoarbelaez.ratebook.user.User;
import com.nicoarbelaez.ratebook.user.dto.UserRegistrationDto;
import com.nicoarbelaez.ratebook.user.dto.UserResponseDto;

public class UserMapper {

    public static User toEntity(UserRegistrationDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDate(dto.getDate());
        user.setProfileImageUrl(dto.getProfileImageUrl());
        
        return user;
    }

    public static UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setDate(user.getDate());
        dto.setProfileImageUrl(user.getProfileImageUrl());

        return dto;
    }
}
