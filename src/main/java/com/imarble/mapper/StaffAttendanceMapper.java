package com.imarble.mapper;

import com.imarble.dto.StaffAttendanceDto;
import com.imarble.entities.Staff;
import com.imarble.entities.StaffAttendance;

public class StaffAttendanceMapper {
    public static StaffAttendance toEntity(StaffAttendanceDto dto, Staff staff) {
        return StaffAttendance.builder()
                .staff(staff)
                .date(dto.getDate())
                .status(dto.getStatus())
                .build();
    }

    public static StaffAttendanceDto toDto(StaffAttendance attendance) {
        StaffAttendanceDto dto = new StaffAttendanceDto();
        dto.setStaffId(attendance.getStaff().getStaffId());
        dto.setDate(attendance.getDate());
        dto.setStatus(attendance.getStatus());
        return dto;
    }
}
