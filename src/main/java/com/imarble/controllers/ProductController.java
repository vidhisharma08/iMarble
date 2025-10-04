package com.imarble.controllers;

import com.imarble.dto.ProductDto;
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
    public ProductDto createProduct(@RequestBody ProductDto dto) {
        return productService.createProduct(dto);
    }

    @PutMapping("/update/{pid}")
    public ProductDto updateProduct(@PathVariable Long pid, @RequestBody ProductDto dto) {
        return productService.updateProduct(pid, dto);
    }

    @GetMapping("/getproduct/{pid}")
    public ProductDto getProductById(@PathVariable Long pid) {
        return productService.getProductById(pid);
    }

    @GetMapping("/getallproducts")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/del/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long pid) {
        productService.deleteProduct(pid);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
