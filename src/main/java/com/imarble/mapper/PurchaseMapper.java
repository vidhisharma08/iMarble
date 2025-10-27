package com.imarble.mapper;

import java.time.LocalDate;

import com.imarble.dto.PurchaseDto;
import com.imarble.entities.Clients;
import com.imarble.entities.Purchase;

public class PurchaseMapper {

    public static PurchaseDto toDto(Purchase purchase) {
        if(purchase == null) return null;

        return PurchaseDto.builder()
                .pid(purchase.getPid())
                .billAmount(purchase.getBillAmount())
                .invoiceNumber(purchase.getInvoiceNumber())
                .date(purchase.getDate())
                .clientId(purchase.getClient().getClientid())
                .build();
    }

    public static Purchase toEntity(PurchaseDto dto, Clients client) {
        if(dto == null || client == null) return null;

        return Purchase.builder()
                .pid(dto.getPid())
                .billAmount(dto.getBillAmount())
                .invoiceNumber(dto.getInvoiceNumber())
                .date(dto.getDate() != null ? dto.getDate() : LocalDate.now())
                .client(client)
                .build();
    }
}
