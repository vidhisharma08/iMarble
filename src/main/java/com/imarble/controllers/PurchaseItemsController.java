package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.PurchaseItemsDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.PurchaseItemsService;

@RestController
@RequestMapping("/api/purchase-items")
public class PurchaseItemsController {

    @Autowired
    private PurchaseItemsService purchaseItemsService;

    @PostMapping("/addpurchase-item")
    public ResponseEntity<ApiResponse<PurchaseItemsDto>> createPurchaseItem(@RequestBody PurchaseItemsDto dto){
        return ResponseEntity.ok(new ApiResponse<>(true, "Purchase Item added successfully", purchaseItemsService.createPurchaseItem(dto)));
    }

    @GetMapping("/getpurchase-item/{id}")
    public ResponseEntity<ApiResponse<PurchaseItemsDto>> getPurchaseItem(@PathVariable Long id){
        return ResponseEntity.ok(new ApiResponse<>(true, "Purchase Item fetched successfully", purchaseItemsService.getPurchaseItemById(id)));
    }

    @GetMapping("/getallpurchase-item")
    public ResponseEntity<ApiResponse<List<PurchaseItemsDto>>> getAllPurchaseItems(){
        return ResponseEntity.ok(new ApiResponse<>(true, "All Purchase Items fetched successfully", purchaseItemsService.getAllPurchaseItems()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<PurchaseItemsDto>> updatePurchaseItem(@PathVariable Long id,
                                                                            @RequestBody PurchaseItemsDto dto){
        return ResponseEntity.ok(new ApiResponse<>(true, "Purchase Item updated successfully", purchaseItemsService.updatePurchaseItem(id, dto)));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePurchaseItem(@PathVariable Long id){
        purchaseItemsService.deletePurchaseItem(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Purchase Item deleted successfully", null));
    }
}
