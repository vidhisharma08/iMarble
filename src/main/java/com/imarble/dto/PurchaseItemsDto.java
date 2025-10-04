package com.imarble.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseItemsDto {
    private Long id;
    private Long productId;
    private Long purchaseId;
    private int quantity;
    private double amount;
}
