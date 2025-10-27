package com.imarble.mapper;

import com.imarble.dto.PurchaseItemsDto;
import com.imarble.entities.Product;
import com.imarble.entities.Purchase;
import com.imarble.entities.PurchaseItems;

public class PurchaseItemsMapper {

    // Convert DTO to Entity using builder
    public static PurchaseItems toEntity(PurchaseItemsDto dto, Product product, Purchase purchase) {
        if(dto == null || product == null || purchase == null) return null;

        return PurchaseItems.builder()
                .id(dto.getId())
                .product(product)
                .purchase(purchase)
                .quantity(dto.getQuantity())
                .amount(dto.getAmount()) // or quantity * product.getPricePerUnit() if you want auto-calculation
                .build();
    }

    // Convert Entity to DTO using builder
    public static PurchaseItemsDto toDto(PurchaseItems entity) {
        if(entity == null) return null;

        return PurchaseItemsDto.builder()
                .id(entity.getId())
                .productId(entity.getProduct().getPid())
                .purchaseId(entity.getPurchase().getPid())
                .quantity(entity.getQuantity())
                .amount(entity.getAmount())
                .build();
    }
}
