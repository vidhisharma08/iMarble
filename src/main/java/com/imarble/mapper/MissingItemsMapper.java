package com.imarble.mapper;

import org.springframework.stereotype.Component;

import com.imarble.dto.MissingItemsDto;
import com.imarble.entities.MissingItems;
import com.imarble.entities.Product;
@Component
public class MissingItemsMapper {
	   public MissingItems toEntity(MissingItemsDto dto, Product product) {
	        MissingItems item = new MissingItems();
	        item.setMissid(dto.getMissid());
	        item.setQty(dto.getQty());
	        item.setDescription(dto.getDescription());
	        item.setType(dto.getType());
	        item.setProduct(product);
	        return item;
	    }

	    public MissingItemsDto toDto(MissingItems entity) {
	        MissingItemsDto dto = new MissingItemsDto();
	        dto.setMissid(entity.getMissid());
	        dto.setQty(entity.getQty());
	        dto.setDescription(entity.getDescription());
	        dto.setType(entity.getType());
	        dto.setProductId(entity.getProduct().getPid());
	        return dto;
	    }
}
