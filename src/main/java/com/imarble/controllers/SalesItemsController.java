package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.SalesItemsDto;
import com.imarble.services.SalesItemsService;

@RestController
@RequestMapping("/api/salesitems")
public class SalesItemsController {

    @Autowired
    private SalesItemsService salesItemsService;

    @PostMapping("/addsalesitem")
    public SalesItemsDto createSalesItem(@RequestBody SalesItemsDto dto) {
        return salesItemsService.createSalesItem(dto);
    }

    @GetMapping("/getsaleitem/{id}")
    public SalesItemsDto getSalesItemById(@PathVariable Long id) {
        return salesItemsService.getSalesItemById(id);
    }

    @GetMapping("/getallsalesitems")
    public List<SalesItemsDto> getAllSalesItems() {
        return salesItemsService.getAllSalesItems();
    }

    @PutMapping("/update/{id}")
    public SalesItemsDto updateSalesItem(@PathVariable Long id, @RequestBody SalesItemsDto dto) {
        return salesItemsService.updateSalesItem(id, dto);
    }

    @DeleteMapping("/del/{id}")
    public String deleteSalesItem(@PathVariable Long id) {
        salesItemsService.deleteSalesItem(id);
        return ("Sales Item deleted successfully");
    }
}
