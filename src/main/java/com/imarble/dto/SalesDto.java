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
public class SalesDto {
    private Long sid;
    private Long clientId;
    private Long branchId;
    private String invoiceNumber;
    private Double billAmount;
    private String type;   // CUSTOMER / DEALER
    private String status; // BOOKED / DISPATCHED / DONE
    private LocalDate date;
}
