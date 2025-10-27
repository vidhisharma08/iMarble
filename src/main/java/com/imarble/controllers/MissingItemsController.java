package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.MissingItemsDto;
import com.imarble.services.MissingItemsService;
import com.imarble.dto.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/missing-item")
public class MissingItemsController {
    @Autowired
    private MissingItemsService missingItemsService;

    // Add missing item
    @PostMapping("/addmissingitem")
    public ResponseEntity<ApiResponse<MissingItemsDto>> addMissingItem(@Valid @RequestBody MissingItemsDto dto) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Missing item added successfully", missingItemsService.addMissingItem(dto)));
    }

    // Get all missing items
    @GetMapping("/allmissingitems")
    public ResponseEntity<ApiResponse<List<MissingItemsDto>>> getAllMissingItems() {
        return ResponseEntity.ok(new ApiResponse<>(true, "All missing items fetched successfully", missingItemsService.getAllMissingItems()));
    }

    // Get missing item by ID
    @GetMapping("/missingitem/{id}")
    public ResponseEntity<ApiResponse<MissingItemsDto>> getMissingItemById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Missing item fetched successfully", missingItemsService.getMissingItemById(id)));
    }

    // Update missing item
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<MissingItemsDto>> updateMissingItem(@PathVariable Long id,
                                                                           @Valid @RequestBody MissingItemsDto dto) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Missing item updated successfully", missingItemsService.updateMissingItem(id, dto)));
    }

    // Delete missing item
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMissingItem(@PathVariable Long id) {
        missingItemsService.deleteMissingItem(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Missing item deleted successfully", null));
    }
}
