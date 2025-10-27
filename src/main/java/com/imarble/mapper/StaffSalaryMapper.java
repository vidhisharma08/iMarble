package com.imarble.mapper;

import com.imarble.dto.StaffSalaryDto;
import com.imarble.entities.Staff;
import com.imarble.entities.StaffSalary;

public class StaffSalaryMapper {
    public static StaffSalary toEntity(StaffSalaryDto dto, Staff staff) {
        return StaffSalary.builder()
                .staff(staff)
                .month(dto.getMonth())
                .year(dto.getYear())
                .paymentDate(dto.getPaymentDate())
                .amount(dto.getAmount())
                .mode(dto.getMode())
                .description(dto.getDescription())
                .build();
    }

    public static StaffSalaryDto toDto(StaffSalary salary) {
        StaffSalaryDto dto = new StaffSalaryDto();
        dto.setStaffId(salary.getStaff().getStaffId());
        dto.setMonth(salary.getMonth());
        dto.setYear(salary.getYear());
        dto.setPaymentDate(salary.getPaymentDate());
        dto.setAmount(salary.getAmount());
        dto.setMode(salary.getMode());
        dto.setDescription(salary.getDescription());
        return dto;
    }
}
