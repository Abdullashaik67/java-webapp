package com.example.demo.service;

import com.example.demo.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();

    // Add new item
    public Item addItem(Item item) {
        items.add(item);
        return item;
    }

    // Get item by ID
    public Optional<Item> getItemById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }
}