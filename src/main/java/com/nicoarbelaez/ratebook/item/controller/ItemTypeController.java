package com.nicoarbelaez.ratebook.item.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicoarbelaez.ratebook.item.enums.ItemType;

@RestController
@RequestMapping("/api/item-types")
public class ItemTypeController {

    @GetMapping
    public ResponseEntity<ItemType[]> getItemTypes() {
        ItemType[] itemTypes = ItemType.values();
        return ResponseEntity.status(HttpStatus.OK).body(itemTypes);
    }
}