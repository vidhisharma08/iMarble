package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.BrandDto;
import com.imarble.services.BrandService;
import com.imarble.dto.ApiResponse;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    // Create Brand
    @PostMapping("/addbrand")
    public ResponseEntity<ApiResponse<BrandDto>> create(@RequestBody BrandDto dto) {
        BrandDto brand = brandService.createBrand(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Brand created successfully", brand));
    }

    // Get Brand By ID
    @GetMapping("/getbrand/{id}")
    public ResponseEntity<ApiResponse<BrandDto>> getById(@PathVariable Long id) {
        BrandDto brand = brandService.getBrandById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Brand fetched successfully", brand));
    }

    // Get All Brands
    @GetMapping("/allbrands")
    public ResponseEntity<ApiResponse<List<BrandDto>>> getAll() {
        List<BrandDto> brands = brandService.getAllBrands();
        return ResponseEntity.ok(new ApiResponse<>(true, "Brands fetched successfully", brands));
    }

    // Update Brand
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<BrandDto>> update(@PathVariable Long id, @RequestBody BrandDto dto) {
        BrandDto updatedBrand = brandService.updateBrand(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Brand updated successfully", updatedBrand));
    }

    // Delete Brand
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Brand deleted successfully", null));
    }
}
