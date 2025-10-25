package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imarble.dto.StockTrackerDto;
import com.imarble.services.StockTrackerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stock-tracker")
public class StockTrackerController {

    @Autowired

    private StockTrackerService stockTrackerService;

    // Add new stock tracker entry
    @PostMapping("/add")
    public ResponseEntity<StockTrackerDto> addStock(@Valid @RequestBody StockTrackerDto dto) {
        return ResponseEntity.ok(stockTrackerService.addStockTracker(dto));
    }

    // Get all stock tracker entries
    @GetMapping("/allstocks")
    public ResponseEntity<List<StockTrackerDto>> getAllStockTrackers() {
        return ResponseEntity.ok(stockTrackerService.getAllStockTrackers());
    }

    // Get stock entries for a product
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<StockTrackerDto>> getStockByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(stockTrackerService.getStockTrackersByProduct(productId));
    }

    // Get final stock quantity for a product
    @GetMapping("/product/{productId}/final")
    public ResponseEntity<Integer> getFinalStock(@PathVariable Long productId) {
        return ResponseEntity.ok(stockTrackerService.getFinalStock(productId));
    }
}
