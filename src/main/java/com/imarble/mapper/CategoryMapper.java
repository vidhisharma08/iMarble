package com.imarble.mapper;

import com.imarble.dto.CategoryDto;
import com.imarble.entities.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryDto dto) {
        return Category.builder()
                .cateid(dto.getCateid())
                .title(dto.getTitle())
                .cdesc(dto.getCdesc())
                .image(dto.getImage())
                .status(dto.getStatus())
                .build();
    }

    public static CategoryDto toDto(Category entity) {
        CategoryDto dto = new CategoryDto();
        dto.setCateid(entity.getCateid());
        dto.setTitle(entity.getTitle());
        dto.setCdesc(entity.getCdesc());
        dto.setImage(entity.getImage());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
