package com.imarble.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDto {
    private Long pid;
    private Double billAmount;
    private String invoiceNumber;
    private LocalDate date;
    private Long clientId;  // store client reference as ID
}
