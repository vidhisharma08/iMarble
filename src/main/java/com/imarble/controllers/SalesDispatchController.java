package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.SalesDispatchDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.SalesDispatchService;

@RestController
@RequestMapping("/api/sales-dispatch")
public class SalesDispatchController {

    @Autowired
    private SalesDispatchService dispatchService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<SalesDispatchDto>> createDispatch(@RequestBody SalesDispatchDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sales Dispatch added successfully", dispatchService.createDispatch(dto))
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<SalesDispatchDto>> getDispatch(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sales Dispatch fetched successfully", dispatchService.getDispatchById(id))
        );
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse<List<SalesDispatchDto>>> getAllDispatches() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "All Sales Dispatches fetched successfully", dispatchService.getAllDispatches())
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<SalesDispatchDto>> updateDispatch(@PathVariable("id") Long id, @RequestBody SalesDispatchDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sales Dispatch updated successfully", dispatchService.updateDispatch(id, dto))
        );
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteDispatch(@PathVariable("id") Long id) {
        dispatchService.deleteDispatch(id);
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Sales Dispatch deleted successfully", null)
        );
    }
}
