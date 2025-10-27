package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.StockTrackerDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.StockTrackerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stock-tracker")
public class StockTrackerController {

    @Autowired
    private StockTrackerService stockTrackerService;

    // Add new stock tracker entry
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<StockTrackerDto>> addStock(@Valid @RequestBody StockTrackerDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Stock entry added successfully", stockTrackerService.addStockTracker(dto))
        );
    }

    // Get all stock tracker entries
    @GetMapping("/allstocks")
    public ResponseEntity<ApiResponse<List<StockTrackerDto>>> getAllStockTrackers() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "All stock entries fetched successfully", stockTrackerService.getAllStockTrackers())
        );
    }

    // Get stock entries for a product
    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<List<StockTrackerDto>>> getStockByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Stock entries fetched for product", stockTrackerService.getStockTrackersByProduct(productId))
        );
    }

    // Get final stock quantity for a product
    @GetMapping("/product/{productId}/final")
    public ResponseEntity<ApiResponse<Integer>> getFinalStock(@PathVariable Long productId) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Final stock quantity fetched", stockTrackerService.getFinalStock(productId))
        );
    }
}
