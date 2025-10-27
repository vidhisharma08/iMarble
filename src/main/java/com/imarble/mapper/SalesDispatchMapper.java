package com.imarble.mapper;

import com.imarble.dto.SalesDispatchDto;
import com.imarble.entities.Sales;
import com.imarble.entities.SalesDispatch;
import com.imarble.entities.Staff;

public class SalesDispatchMapper {

    public static SalesDispatchDto toDto(SalesDispatch dispatch) {
        if(dispatch == null) return null;
        return SalesDispatchDto.builder()
                .disid(dispatch.getDisid())
                .date(dispatch.getDate())
                .dispatcherId(dispatch.getDispatcher().getStaffId())
                .salesId(dispatch.getSales().getSid())
                .build();
    }

    public static SalesDispatch toEntity(SalesDispatchDto dto, Staff dispatcher, Sales sales) {
        if(dto == null || dispatcher == null || sales == null) return null;
        return SalesDispatch.builder()
                .disid(dto.getDisid())
                .date(dto.getDate() != null ? dto.getDate() : java.time.LocalDate.now())
                .dispatcher(dispatcher)
                .sales(sales)
                .build();
    }
}
