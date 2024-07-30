package com.nicoarbelaez.ratebook.item.dto;

import com.nicoarbelaez.ratebook.item.enums.ItemType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {
    private Long id;
    private String title;
    private String imageUrl;
    private String description;
    private String tag;
    private Float averageRating = 0.0f;
    private ItemType type;
}
