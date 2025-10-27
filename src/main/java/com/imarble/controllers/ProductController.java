package com.imarble.controllers;

import com.imarble.dto.ProductDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<ApiResponse<ProductDto>> createProduct(@RequestBody ProductDto dto) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Product added successfully", productService.createProduct(dto)));
    }

    @PutMapping("/update/{pid}")
    public ResponseEntity<ApiResponse<ProductDto>> updateProduct(@PathVariable Long pid, @RequestBody ProductDto dto) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Product updated successfully", productService.updateProduct(pid, dto)));
    }

    @GetMapping("/getproduct/{pid}")
    public ResponseEntity<ApiResponse<ProductDto>> getProductById(@PathVariable Long pid) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Product fetched successfully", productService.getProductById(pid)));
    }

    @GetMapping("/getallproducts")
    public ResponseEntity<ApiResponse<List<ProductDto>>> getAllProducts() {
        return ResponseEntity.ok(new ApiResponse<>(true, "All products fetched successfully", productService.getAllProducts()));
    }

    @DeleteMapping("/del/{pid}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long pid) {
        productService.deleteProduct(pid);
        return ResponseEntity.ok(new ApiResponse<>(true, "Product deleted successfully", null));
    }
}
