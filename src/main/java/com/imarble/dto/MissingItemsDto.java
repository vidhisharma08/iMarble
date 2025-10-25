package com.imarble.dto;

import com.imarble.entities.MissingItems.MissingItemType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MissingItemsDto {
    private Long missid;

    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer qty;

    private String description;

    @NotNull(message = "Missing item type is required")
    private MissingItemType type;
}
