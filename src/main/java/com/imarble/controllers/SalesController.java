package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.SalesDto;
import com.imarble.services.SalesService;


@RestController
@RequestMapping("/api/sales")
public class SalesController {

	@Autowired
    private SalesService salesService;

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
