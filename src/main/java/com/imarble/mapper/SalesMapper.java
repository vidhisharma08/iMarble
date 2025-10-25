package com.imarble.mapper;

import java.time.LocalDate;

import com.imarble.dto.SalesDto;
import com.imarble.entities.Branch;
import com.imarble.entities.Clients;
import com.imarble.entities.Sales;

public class SalesMapper {

    // Convert Sales entity → SalesDto
	public static SalesDto toDto(Sales sales) {
	    if (sales == null) return null;

	    return SalesDto.builder()
	            .sid(sales.getSid())
	            .invoiceNumber(sales.getInvoiceNumber())
	            .billAmount(sales.getBillAmount())
	            .date(sales.getDate())
	            .clientId(sales.getClient().getClientid())
	            .branchId(sales.getBranch().getBranchId())
	            .type(sales.getType().name())     // convert enum → String
	            .status(sales.getStatus().name()) // convert enum → String
	            .build();
	}


    // Convert SalesDto → Sales entity
	public static Sales toEntity(SalesDto dto, Clients client, Branch branch) {
	    if (dto == null || client == null || branch == null) return null;

	    return Sales.builder()
	            .sid(dto.getSid())
	            .invoiceNumber(dto.getInvoiceNumber())
	            .billAmount(dto.getBillAmount())
	            .date(dto.getDate() != null ? dto.getDate() : LocalDate.now())
	            .client(client)
	            .branch(branch)
	            .type(Sales.SalesType.valueOf(dto.getType()))     // String → enum
	            .status(Sales.SalesStatus.valueOf(dto.getStatus())) // String → enum
	            .build();
	}

}
