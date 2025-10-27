package com.imarble.mapper;

import org.springframework.stereotype.Component;

import com.imarble.dto.StockTrackerDto;
import com.imarble.entities.Product;
import com.imarble.entities.StockTracker;

@Component
public class StockTrackerMapper {
    
    public StockTracker toEntity(StockTrackerDto dto, Product product) {
        StockTracker e = new StockTracker();
        e.setTrackerid(dto.getTrackerid());
        e.setProduct(product);
        e.setType(dto.getType());
        e.setReferenceid(dto.getReferenceid());
        e.setQty(dto.getQty());
        e.setStatus(dto.getStatus());
        return e;
    }

    
    public StockTrackerDto toDto(StockTracker entity) {
        if (entity == null) return null;
        StockTrackerDto dto = new StockTrackerDto();
        dto.setTrackerid(entity.getTrackerid());
        if (entity.getProduct() != null) dto.setProductId(entity.getProduct().getPid());
        dto.setType(entity.getType());
        dto.setReferenceid(entity.getReferenceid());
        dto.setQty(entity.getQty());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
