package com.imarble.mapper;

import com.imarble.dto.BranchDto;
import com.imarble.entities.Branch;

public class BranchMapper {
    public static Branch toEntity(BranchDto dto) {
        return Branch.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .mobile(dto.getMobile())
                .status(dto.getStatus())
                .build();
    }

    public static BranchDto toDto(Branch branch) {
        BranchDto dto = new BranchDto();
        dto.setName(branch.getName());
        dto.setAddress(branch.getAddress());
        dto.setMobile(branch.getMobile());
        dto.setStatus(branch.getStatus());
        return dto;
    }
}
