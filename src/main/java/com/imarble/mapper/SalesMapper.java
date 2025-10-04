//package com.imarble.mapper;
//
//import com.imarble.dto.SalesDto;
//import com.imarble.entities.Branch;
//import com.imarble.entities.Clients;
//import com.imarble.entities.Sales;
//
//public class SalesMapper {
//
//    public static SalesDto toDto(Sales sales) {
//        if (sales == null) return null;
//
//        return SalesDto.builder()
//                .sid(sales.getSid())
//                .clientId(sales.getClient().getClientid())
//                .branchId(sales.getBranch().getBranchid())
//                .invoiceNumber(sales.getInvoiceNumber())
//                .billAmount(sales.getBillAmount())
//                .type(sales.getType().name())
//                .status(sales.getStatus().name())
//                .date(sales.getDate())
//                .build();
//    }
//
//    public static Sales toEntity(SalesDto dto, Clients client, Branch branch) {
//        if (dto == null || client == null || branch == null) return null;
//
//        return Sales.builder()
//                .sid(dto.getSid())
//                .client(client)
//                .branch(branch)
//                .invoiceNumber(dto.getInvoiceNumber())
//                .billAmount(dto.getBillAmount())
//                .type(dto.getType() != null ? Sales.SalesType.valueOf(dto.getType()) : Sales.SalesType.CUSTOMER)
//                .status(dto.getStatus() != null ? Sales.SalesStatus.valueOf(dto.getStatus()) : Sales.SalesStatus.BOOKED)
//                .date(dto.getDate() != null ? dto.getDate() : java.time.LocalDate.now())
//                .build();
//    }
//}
