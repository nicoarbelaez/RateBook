package com.nicoarbelaez.ratebook.item.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.nicoarbelaez.ratebook.item.enums.ItemType;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreationDto {
    private String title;
    private String imageUrl;
    private String description;
    private String tag;
    private ItemType type;
}
