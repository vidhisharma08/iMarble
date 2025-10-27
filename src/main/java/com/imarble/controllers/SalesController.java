package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.SalesDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.SalesService;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping("/addsale")
    public ResponseEntity<ApiResponse<SalesDto>> createSales(@RequestBody SalesDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sale added successfully", salesService.createSales(dto))
        );
    }

    @GetMapping("/getsale/{id}")
    public ResponseEntity<ApiResponse<SalesDto>> getSales(@PathVariable Long id) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sale fetched successfully", salesService.getSalesById(id))
        );
    }

    @GetMapping("/getallsales")
    public ResponseEntity<ApiResponse<List<SalesDto>>> getAllSales() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "All sales fetched successfully", salesService.getAllSales())
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<SalesDto>> updateSales(@PathVariable Long id, @RequestBody SalesDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sale updated successfully", salesService.updateSales(id, dto))
        );
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSales(@PathVariable Long id) {
        salesService.deleteSales(id);
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sale deleted successfully", null)
        );
    }
}
