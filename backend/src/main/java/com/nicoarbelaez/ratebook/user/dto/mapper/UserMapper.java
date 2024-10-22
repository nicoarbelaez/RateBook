package com.nicoarbelaez.ratebook.user.dto.mapper;

import com.nicoarbelaez.ratebook.user.User;
import com.nicoarbelaez.ratebook.user.dto.UserResponseDto;

public class UserMapper {

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
