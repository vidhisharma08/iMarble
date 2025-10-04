package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.PurchaseItemsDto;
import com.imarble.services.PurchaseItemsService;

@RestController
@RequestMapping("/api/purchase-items")
public class PurchaseItemsController {

    @Autowired
    private PurchaseItemsService purchaseItemsService;

    @PostMapping("/addpurchase-item")
    public ResponseEntity<PurchaseItemsDto> createPurchaseItem(@RequestBody PurchaseItemsDto dto){
        return ResponseEntity.ok(purchaseItemsService.createPurchaseItem(dto));
    }

    @GetMapping("/getpurchase-item/{id}")
    public ResponseEntity<PurchaseItemsDto> getPurchaseItem(@PathVariable Long id){
        return ResponseEntity.ok(purchaseItemsService.getPurchaseItemById(id));
    }

    @GetMapping("/getallpurchase-item")
    public ResponseEntity<List<PurchaseItemsDto>> getAllPurchaseItems(){
        return ResponseEntity.ok(purchaseItemsService.getAllPurchaseItems());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PurchaseItemsDto> updatePurchaseItem(@PathVariable Long id,
                                                               @RequestBody PurchaseItemsDto dto){
        return ResponseEntity.ok(purchaseItemsService.updatePurchaseItem(id, dto));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deletePurchaseItem(@PathVariable Long id){
        purchaseItemsService.deletePurchaseItem(id);
        return ResponseEntity.ok("Purchase Item deleted successfully");
    }
}
