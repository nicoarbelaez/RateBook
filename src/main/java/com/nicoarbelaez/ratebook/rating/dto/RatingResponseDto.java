package com.nicoarbelaez.ratebook.rating.dto;

import com.nicoarbelaez.ratebook.item.dto.ItemResponseDto;
import com.nicoarbelaez.ratebook.user.dto.UserResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingResponseDto {

    private Long id;
    private UserResponseDto user;
    private ItemResponseDto item;
    private Float stars;
}
