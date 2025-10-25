package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imarble.dto.MissingItemsDto;
import com.imarble.services.MissingItemsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/missing-item")
public class MissingItemsController {
    @Autowired
    private MissingItemsService missingItemsService;

    // Add missing item
    @PostMapping("/addmissingitem")
    public ResponseEntity<MissingItemsDto> addMissingItem(@Valid @RequestBody MissingItemsDto dto) {
        return ResponseEntity.ok(missingItemsService.addMissingItem(dto));
    }

    // Get all missing items
    @GetMapping("/allmissingitems")
    public ResponseEntity<List<MissingItemsDto>> getAllMissingItems() {
        return ResponseEntity.ok(missingItemsService.getAllMissingItems());
    }

    // Get missing item by ID
    @GetMapping("/missingitem/{id}")
    public ResponseEntity<MissingItemsDto> getMissingItemById(@PathVariable Long id) {
        return ResponseEntity.ok(missingItemsService.getMissingItemById(id));
    }

    // Update missing item
    @PutMapping("/update/{id}")
    public ResponseEntity<MissingItemsDto> updateMissingItem(@PathVariable Long id,
                                                             @Valid @RequestBody MissingItemsDto dto) {
        return ResponseEntity.ok(missingItemsService.updateMissingItem(id, dto));
    }

    // Delete missing item
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteMissingItem(@PathVariable Long id) {
        missingItemsService.deleteMissingItem(id);
        return ResponseEntity.ok("Missing item deleted successfully");
    }
}
