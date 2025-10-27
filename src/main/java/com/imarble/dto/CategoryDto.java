package com.imarble.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDto {

    private Long cateid;

    @NotBlank(message = "Title is required")
    private String title;

    private String cdesc;

    private String image;

    @NotNull(message = "Status is required")
    private Boolean status;
}
