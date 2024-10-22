package com.nicoarbelaez.ratebook.item.dto;

import com.nicoarbelaez.ratebook.item.enums.ItemType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto {
    private Long id;
    private String title;
    private String imageUrl;
    private String description;
    private String tag;
    private ItemType type;
}
