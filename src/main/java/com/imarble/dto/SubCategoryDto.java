package com.imarble.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoryDto {
    private Long subcateid;
    private String title;
    private String scdesc;
    private String image;
    private Boolean status;
    private Long categoryId; // to link with Category
}
