package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // 1. Add a new item
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {

        // Input Validation
        if (item.getName() == null || item.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Item name is required");
        }

        if (item.getPrice() <= 0) {
            return ResponseEntity.badRequest().body("Price must be greater than 0");
        }

        Item savedItem = itemService.addItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // 2. Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable int id) {

        Optional<Item> item = itemService.getItemById(id);

        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item not found with ID: " + id);
        }
    }
}