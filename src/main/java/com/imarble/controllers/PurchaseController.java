package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.PurchaseDto;
import com.imarble.services.PurchaseService;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/addpurchase")
    public PurchaseDto createPurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.createPurchase(purchaseDto);
    }

    @GetMapping("/getpurchase/{id}")
    public PurchaseDto getPurchase(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id);
    }

    @GetMapping("/getallpurchase")
    public List<PurchaseDto> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @PutMapping("/update/{id}")
    public PurchaseDto updatePurchase(@PathVariable Long id, @RequestBody PurchaseDto purchaseDto) {
        return purchaseService.updatePurchase(id, purchaseDto);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.ok("Purchase deleted successfully");
    }
}
