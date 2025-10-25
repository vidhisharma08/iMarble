package com.imarble.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class DispatchItemsDto {
	    @NotNull
	    private Long dispatchId;

	    @NotNull
	    private Long salesItemId;

	    @NotNull
	    private Integer quantity;

}
