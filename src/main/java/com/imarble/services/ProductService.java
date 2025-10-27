package com.imarble.services;

import com.imarble.dto.ProductDto;
import com.imarble.entities.Brand;
import com.imarble.entities.Category;
import com.imarble.entities.Product;
import com.imarble.entities.SubCategory;
import com.imarble.mapper.ProductMapper;
import com.imarble.repos.BrandRepository;
import com.imarble.repos.CategoryRepository;
import com.imarble.repos.ProductRepository;
import com.imarble.repos.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductMapper mapper;

    public ProductDto createProduct(ProductDto dto) {
        if (productRepository.existsByModelNumber(dto.getModelNumber())) {
            throw new RuntimeException("Product with same model number already exists!");
        }

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId())
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));
        Brand brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        Product product = mapper.toEntity(dto, category, subCategory, brand);
        Product saved = productRepository.save(product);
        return mapper.toDto(saved);
    }

    public ProductDto updateProduct(Long pid, ProductDto dto) {
        Product existing = productRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId())
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));
        Brand brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        existing.setModelNumber(dto.getModelNumber());
        existing.setTitle(dto.getTitle());
        existing.setUnit(dto.getUnit());
        existing.setProdesc(dto.getProdesc());
        existing.setPricePerUnit(dto.getPricePerUnit());
        existing.setImage(dto.getImage());
        existing.setMinStockLevel(dto.getMinStockLevel());
        existing.setStatus(dto.getStatus());
        existing.setCategory(category);
        existing.setSubCategory(subCategory);
        existing.setBrand(brand);

        Product updated = productRepository.save(existing);
        return mapper.toDto(updated);
    }

    public ProductDto getProductById(Long pid) {
        Product product = productRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapper.toDto(product);
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long pid) {
        Product product = productRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}
