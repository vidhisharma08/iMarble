package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.PurchaseDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.PurchaseService;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/addpurchase")
    public ResponseEntity<ApiResponse<PurchaseDto>> createPurchase(@RequestBody PurchaseDto purchaseDto) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Purchase added successfully", purchaseService.createPurchase(purchaseDto)));
    }

    @GetMapping("/getpurchase/{id}")
    public ResponseEntity<ApiResponse<PurchaseDto>> getPurchase(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Purchase fetched successfully", purchaseService.getPurchaseById(id)));
    }

    @GetMapping("/getallpurchase")
    public ResponseEntity<ApiResponse<List<PurchaseDto>>> getAllPurchases() {
        return ResponseEntity.ok(new ApiResponse<>(true, "All purchases fetched successfully", purchaseService.getAllPurchases()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<PurchaseDto>> updatePurchase(@PathVariable Long id, @RequestBody PurchaseDto purchaseDto) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Purchase updated successfully", purchaseService.updatePurchase(id, purchaseDto)));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Purchase deleted successfully", null));
    }
}
