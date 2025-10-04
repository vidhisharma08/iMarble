package com.imarble.mapper;

import com.imarble.dto.ProductDto;
import com.imarble.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        if (product == null) return null;
        return ProductDto.builder()
                .pid(product.getPid())
                .modelNumber(product.getModelNumber())
                .title(product.getTitle())
                .unit(product.getUnit())
                .prodesc(product.getProdesc())
                .pricePerUnit(product.getPricePerUnit())
                .image(product.getImage())
                .minStockLevel(product.getMinStockLevel())
                .status(product.getStatus())
                .categoryId(product.getCategory() != null ? product.getCategory().getCateid() : null)
                .subCategoryId(product.getSubCategory() != null ? product.getSubCategory().getSubcateid() : null)
                .brandId(product.getBrand() != null ? product.getBrand().getBrandid() : null)
                .build();
    }

    public Product toEntity(ProductDto dto, com.imarble.entities.Category category,
                            com.imarble.entities.SubCategory subCategory,
                            com.imarble.entities.Brand brand) {
        if (dto == null) return null;
        return Product.builder()
                .pid(dto.getPid())
                .modelNumber(dto.getModelNumber())
                .title(dto.getTitle())
                .unit(dto.getUnit())
                .prodesc(dto.getProdesc())
                .pricePerUnit(dto.getPricePerUnit())
                .image(dto.getImage())
                .minStockLevel(dto.getMinStockLevel())
                .status(dto.getStatus())
                .category(category)
                .subCategory(subCategory)
                .brand(brand)
                .build();
    }
}
