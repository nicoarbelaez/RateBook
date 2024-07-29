package com.nicoarbelaez.ratebook.user.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String profileImageUrl;
    private String email;
    private String password;

    private LocalDate date;
    
    private int reviewsCount;
    private int itemsEvaluatedCount;
}
