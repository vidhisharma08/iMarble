package com.imarble.mapper;

import com.imarble.dto.BrandDto;
import com.imarble.entities.Brand;

public class BrandMapper {

    public static BrandDto toDto(Brand brand) {
        if (brand == null) return null;
        return BrandDto.builder()
                .brandid(brand.getBrandid())
                .title(brand.getTitle())
                .image(brand.getImage())
                .status(brand.getStatus())
                .build();
    }

    public static Brand toEntity(BrandDto dto) {
        if (dto == null) return null;
        return Brand.builder()
                .brandid(dto.getBrandid())
                .title(dto.getTitle())
                .image(dto.getImage())
                .status(dto.getStatus())
                .build();
    }
}
