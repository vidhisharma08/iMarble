package com.imarble.dto;

import com.imarble.entities.StockTracker.StockType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StockTrackerDto {
    private Long trackerid;

    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Type is required")
    private StockType type;

    @NotNull(message = "Reference ID is required")
    private Long referenceid;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer qty;

    @NotNull(message = "Status is required")
    private Boolean status;
}
