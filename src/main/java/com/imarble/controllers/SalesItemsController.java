package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.SalesItemsDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.SalesItemsService;

@RestController
@RequestMapping("/api/salesitems")
public class SalesItemsController {

    @Autowired
    private SalesItemsService salesItemsService;

    @PostMapping("/addsalesitem")
    public ResponseEntity<ApiResponse<SalesItemsDto>> createSalesItem(@RequestBody SalesItemsDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sales Item added successfully", salesItemsService.createSalesItem(dto))
        );
    }

    @GetMapping("/getsaleitem/{id}")
    public ResponseEntity<ApiResponse<SalesItemsDto>> getSalesItemById(@PathVariable Long id) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sales Item fetched successfully", salesItemsService.getSalesItemById(id))
        );
    }

    @GetMapping("/getallsalesitems")
    public ResponseEntity<ApiResponse<List<SalesItemsDto>>> getAllSalesItems() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "All Sales Items fetched successfully", salesItemsService.getAllSalesItems())
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<SalesItemsDto>> updateSalesItem(@PathVariable Long id, @RequestBody SalesItemsDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sales Item updated successfully", salesItemsService.updateSalesItem(id, dto))
        );
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSalesItem(@PathVariable Long id) {
        salesItemsService.deleteSalesItem(id);
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sales Item deleted successfully", null)
        );
    }
}
