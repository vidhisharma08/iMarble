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
public class SalesDispatchDto {
    private Long disid;
    private LocalDate date;
    private Long dispatcherId; // Staff ID
    private Long salesId;      // Sales ID
}
