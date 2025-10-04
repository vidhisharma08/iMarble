package com.imarble.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.imarble.dto.SalesDto;
import com.imarble.services.SalesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @PostMapping("/addsale")
    public SalesDto createSales(@RequestBody SalesDto dto) {
        return salesService.createSales(dto);
    }

    @GetMapping("/getsale/{id}")
    public SalesDto getSales(@PathVariable Long id) {
        return salesService.getSalesById(id);
    }

    @GetMapping("/getallsales")
    public List<SalesDto> getAllSales() {
        return salesService.getAllSales();
    }

    @PutMapping("/update/{id}")
    public SalesDto updateSales(@PathVariable Long id, @RequestBody SalesDto dto) {
        return salesService.updateSales(id, dto);
    }

    @DeleteMapping("/del/{id}")
    public String deleteSales(@PathVariable Long id) {
        salesService.deleteSales(id);
        return "Sales deleted successfully";
    }
}
