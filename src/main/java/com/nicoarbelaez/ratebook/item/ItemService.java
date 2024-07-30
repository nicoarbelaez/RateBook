package com.nicoarbelaez.ratebook.item;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nicoarbelaez.ratebook.item.dto.ItemCreationDto;
import com.nicoarbelaez.ratebook.item.dto.mapper.ItemMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Transactional
    public Optional<Item> createItem(ItemCreationDto dto) {
        if (itemRepository.findByTitle(dto.getTitle()).isPresent()) {
            return Optional.empty();
        }

        Item item = ItemMapper.toEntity(dto);
        return Optional.of(itemRepository.save(item));
    }

    @Transactional
    public boolean deleteItem(Long id) {
        return itemRepository.findById(id).map(item -> {
            itemRepository.delete(item);
            return true;
        }).orElse(false);
    }

    @Transactional
    public Optional<Item> updateItem(Long id, Item item) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (!existingItem.isPresent()) {
            return Optional.empty();
        }

        Optional<Item> itemWithTitle = itemRepository.findByTitle(item.getTitle());
        if (itemWithTitle.isPresent() && !itemWithTitle.get().getId().equals(id)) {
            return Optional.empty();
        }

        item.setId(id);
        return Optional.of(itemRepository.save(item));
    }
}
