package com.imarble.dto;

import java.time.LocalDate;

import com.imarble.entities.StaffAttendance.AttendanceStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StaffAttendanceDto {
    @NotNull(message = "Staff ID is required")
    private Long staffId;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Status is required")
    private AttendanceStatus status;
}
