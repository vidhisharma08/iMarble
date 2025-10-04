package com.imarble.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.BrandDto;
import com.imarble.services.BrandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping("/addbrand")
    public ResponseEntity<BrandDto> create(@RequestBody BrandDto dto) {
        return ResponseEntity.ok(brandService.createBrand(dto));
    }

    @GetMapping("/getbrand/{id}")
    public ResponseEntity<BrandDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(brandService.getBrandById(id));
    }

    @GetMapping("/allbrands")
    public ResponseEntity<List<BrandDto>> getAll() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BrandDto> update(@PathVariable Long id, @RequestBody BrandDto dto) {
        return ResponseEntity.ok(brandService.updateBrand(id, dto));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok("Brand deleted successfully");
    }
}
