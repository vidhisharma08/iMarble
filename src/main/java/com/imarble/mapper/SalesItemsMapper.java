package com.imarble.mapper;

import com.imarble.dto.SalesItemsDto;
import com.imarble.entities.Product;
import com.imarble.entities.Sales;
import com.imarble.entities.SalesItems;

public class SalesItemsMapper {

    public static SalesItemsDto toDto(SalesItems salesItems) {
        if(salesItems == null) return null;

        return SalesItemsDto.builder()
                .id(salesItems.getId())
                .productId(salesItems.getProduct().getPid())
                .salesId(salesItems.getSales().getSid())
                .quantity(salesItems.getQuantity())
                .amount(salesItems.getAmount())
                .build();
    }

    public static SalesItems toEntity(SalesItemsDto dto, Product product, Sales sales) {
        if(dto == null || product == null || sales == null) return null;

        return SalesItems.builder()
                .id(dto.getId())
                .product(product)
                .sales(sales)
                .quantity(dto.getQuantity())
                .amount(dto.getAmount())
                .build();
    }
}
