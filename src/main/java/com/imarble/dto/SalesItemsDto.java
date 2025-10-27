package com.imarble.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesItemsDto {
    private Long id;
    private Long productId;
    private Long salesId;
    private Integer quantity;
    private Double amount;
}
