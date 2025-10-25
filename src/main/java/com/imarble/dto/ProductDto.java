package com.imarble.dto;

import com.imarble.entities.Product.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long pid;
    private String modelNumber;
    private String title;
    private Unit unit;
    private String prodesc;
    private Double pricePerUnit;
    private String image;
    private Integer minStockLevel;
    private Boolean status;
    private Long categoryId;
    private Long subCategoryId;
    private Long brandId;
}
