package com.nicoarbelaez.ratebook.item.dto.mapper;

import com.nicoarbelaez.ratebook.item.Item;
import com.nicoarbelaez.ratebook.item.dto.ItemCreationDto;
import com.nicoarbelaez.ratebook.item.dto.ItemResponseDto;

public class ItemMapper {
    public static Item toEntity(ItemCreationDto dto) {
        Item item = new Item();
        item.setTitle(dto.getTitle());
        item.setImageUrl(dto.getImageUrl());
        item.setDescription(dto.getDescription());
        item.setTag(dto.getTag());
        item.setType(dto.getType());
        return item;
    }

    public static ItemResponseDto toResponseDto(Item item) {
        return new ItemResponseDto(
            item.getId(),
            item.getTitle(),
            item.getImageUrl(),
            item.getDescription(),
            item.getTag(),
            item.getTotalRatings(),
            item.getAverageRating(),
            item.getType()
        );
    }
}
