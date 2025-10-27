package com.imarble.controllers;

import com.imarble.dto.CategoryDto;
import com.imarble.dto.SubCategoryDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.CategoryService;
import com.imarble.services.SubCategoryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    // Create Category
    @PostMapping("/addcategory")
    public ResponseEntity<ApiResponse<CategoryDto>> createCategory(@Valid @RequestBody CategoryDto dto) {
        CategoryDto created = categoryService.createCategory(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Category created successfully", created));
    }

    // Get All Categories
    @GetMapping("/allcategories")
    public ResponseEntity<ApiResponse<List<CategoryDto>>> getAllCategories() {
        List<CategoryDto> list = categoryService.getAllCategories();
        return ResponseEntity.ok(new ApiResponse<>(true, "Categories fetched successfully", list));
    }

    // Get Category by ID
    @GetMapping("/getcategory/{id}")
    public ResponseEntity<ApiResponse<CategoryDto>> getCategoryById(@PathVariable Long id) {
        CategoryDto dto = categoryService.getCategoryById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Category fetched successfully", dto));
    }

    // Update Category
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<CategoryDto>> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDto dto) {
        CategoryDto updated = categoryService.updateCategory(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Category updated successfully", updated));
    }

    // Delete Category
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Category deleted successfully", null));
    }

    // SubCategory endpoints

    @PostMapping("/{categoryId}/subcategories/addsubcategory")
    public ResponseEntity<ApiResponse<SubCategoryDto>> createSubCategory(
            @PathVariable Long categoryId,
            @RequestBody SubCategoryDto dto) {

        dto.setCategoryId(categoryId);
        SubCategoryDto created = subCategoryService.createSubCategory(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "SubCategory created successfully", created));
    }

    @GetMapping("/{categoryId}/subcategories/getallsubcategories")
    public ResponseEntity<ApiResponse<List<SubCategoryDto>>> getSubCategoriesByCategory(@PathVariable Long categoryId) {
        List<SubCategoryDto> list = subCategoryService.getAllSubCategoriesByCategory(categoryId);
        return ResponseEntity.ok(new ApiResponse<>(true, "SubCategories fetched successfully", list));
    }

    @GetMapping("/{categoryId}/subcategories/getsubcategory/{subcateId}")
    public ResponseEntity<ApiResponse<SubCategoryDto>> getSubCategoryById(
            @PathVariable Long categoryId,
            @PathVariable Long subcateId) {

        SubCategoryDto dto = subCategoryService.getSubCategoryByIdAndCategory(subcateId, categoryId);
        return ResponseEntity.ok(new ApiResponse<>(true, "SubCategory fetched successfully", dto));
    }

    @PutMapping("/{categoryId}/subcategories/update/{subcateId}")
    public ResponseEntity<ApiResponse<SubCategoryDto>> updateSubCategory(
            @PathVariable Long categoryId,
            @PathVariable Long subcateId,
            @RequestBody SubCategoryDto dto) {

        dto.setCategoryId(categoryId);
        SubCategoryDto updated = subCategoryService.updateSubCategory(subcateId, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "SubCategory updated successfully", updated));
    }

    @DeleteMapping("/{categoryId}/subcategories/del/{subcateId}")
    public ResponseEntity<ApiResponse<Void>> deleteSubCategory(
            @PathVariable Long categoryId,
            @PathVariable Long subcateId) {

        subCategoryService.deleteSubCategoryByCategory(subcateId, categoryId);
        return ResponseEntity.ok(new ApiResponse<>(true, "SubCategory deleted successfully", null));
    }
}
