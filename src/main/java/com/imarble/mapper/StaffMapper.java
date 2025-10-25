package com.imarble.mapper;

import com.imarble.dto.StaffDto;
import com.imarble.entities.Branch;
import com.imarble.entities.Staff;
import com.imarble.entities.User;

public class StaffMapper {
    public static Staff toEntity(StaffDto dto, Branch branch, User user) {
        return Staff.builder()
                .name(dto.getName())
                .mobile(dto.getMobile())
                .address(dto.getAddress())
                .joinDate(dto.getJoinDate())
                .leavingDate(dto.getLeavingDate())
                .staffType(dto.getStaffType())
                .salaryType(dto.getSalaryType())
                .baseSalary(dto.getBaseSalary())
                .branch(branch)
                .user(user)
                .build();
    }

    public static StaffDto toDto(Staff staff) {
        StaffDto dto = new StaffDto();
        dto.setName(staff.getName());
        dto.setMobile(staff.getMobile());
        dto.setAddress(staff.getAddress());
        dto.setJoinDate(staff.getJoinDate());
        dto.setLeavingDate(staff.getLeavingDate());
        dto.setStaffType(staff.getStaffType());
        dto.setSalaryType(staff.getSalaryType());
        dto.setBaseSalary(staff.getBaseSalary());

        if (staff.getBranch() != null) dto.setBranchId(staff.getBranch().getBranchId());
        if (staff.getUser() != null) dto.setUserId(staff.getUser().getUserId());
        return dto;
    }
}
