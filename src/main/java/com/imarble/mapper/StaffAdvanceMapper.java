package com.imarble.mapper;

import com.imarble.dto.StaffAdvanceDto;
import com.imarble.entities.Staff;
import com.imarble.entities.StaffAdvance;

public class StaffAdvanceMapper {
    public static StaffAdvance toEntity(StaffAdvanceDto dto, Staff staff) {
        return StaffAdvance.builder()
                .staff(staff)
                .month(dto.getMonth())
                .year(dto.getYear())
                .paymentDate(dto.getPaymentDate())
                .amount(dto.getAmount())
                .mode(dto.getMode())
                .build();
    }

    public static StaffAdvanceDto toDto(StaffAdvance advance) {
        StaffAdvanceDto dto = new StaffAdvanceDto();
        dto.setStaffId(advance.getStaff().getStaffId());
        dto.setMonth(advance.getMonth());
        dto.setYear(advance.getYear());
        dto.setPaymentDate(advance.getPaymentDate());
        dto.setAmount(advance.getAmount());
        dto.setMode(advance.getMode());
        return dto;
    }
}
