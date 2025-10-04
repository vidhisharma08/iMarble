package com.imarble.mapper;

import com.imarble.dto.SubCategoryDto;
import com.imarble.entities.Category;
import com.imarble.entities.SubCategory;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryMapper {

    // Convert Entity → DTO
    public SubCategoryDto toDto(SubCategory subCategory) {
        if (subCategory == null) return null;

        return SubCategoryDto.builder()
                .subcateid(subCategory.getSubcateid())
                .title(subCategory.getTitle())
                .scdesc(subCategory.getScdesc())
                .image(subCategory.getImage())
                .status(subCategory.getStatus())
                .categoryId(subCategory.getCategory() != null ? subCategory.getCategory().getCateid() : null)
                .build();
    }

    // Convert DTO → Entity
    public SubCategory toEntity(SubCategoryDto dto, Category category) {
        if (dto == null) return null;

        return SubCategory.builder()
                .subcateid(dto.getSubcateid())
                .title(dto.getTitle())
                .scdesc(dto.getScdesc())
                .image(dto.getImage())
                .status(dto.getStatus())
                .category(category)
                .build();
    }
}
