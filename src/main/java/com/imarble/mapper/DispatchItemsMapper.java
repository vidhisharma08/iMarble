package com.imarble.mapper;

import com.imarble.dto.DispatchItemsDto;
import com.imarble.entities.DispatchItems;
import com.imarble.entities.SalesDispatch;
import com.imarble.entities.SalesItems;

public class DispatchItemsMapper {
	  public static DispatchItems toEntity(DispatchItemsDto dto, SalesDispatch dispatch, SalesItems salesItem) {
	        DispatchItems entity = new DispatchItems();
	        entity.setDispatch(dispatch);
	        entity.setSalesItem(salesItem);
	        entity.setQuantity(dto.getQuantity());
	        return entity;
	    }
}
