package com.imarble.controllers;

import com.imarble.dto.CategoryDto;
import com.imarble.dto.SubCategoryDto;
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


    // Create category
    @PostMapping("/addcategory")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto dto) {
        return ResponseEntity.ok(categoryService.createCategory(dto));
    }

    // Get all categories
    @GetMapping("/allcategories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // Get category by ID
    @GetMapping("/getcategory/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    // Update category
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDto dto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, dto));
    }

    // Delete category
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
    
    
    @PostMapping("/{categoryId}/subcategories/addsubcategory")
    public ResponseEntity<SubCategoryDto> createSubCategory(
            @PathVariable Long categoryId,
            @RequestBody SubCategoryDto dto) {

        dto.setCategoryId(categoryId);
        SubCategoryDto created = subCategoryService.createSubCategory(dto);
        return ResponseEntity.ok(created);
    }

    // Get all SubCategories of a Category
    @GetMapping("/{categoryId}/subcategories/getallsubcategories")
    public ResponseEntity<List<SubCategoryDto>> getSubCategoriesByCategory(
            @PathVariable Long categoryId) {

        List<SubCategoryDto> list = subCategoryService.getAllSubCategoriesByCategory(categoryId);
        return ResponseEntity.ok(list);
    }

    // Get SubCategory by ID under a Category
    @GetMapping("/{categoryId}/subcategories/getsubcategory/{subcateId}")
    public ResponseEntity<SubCategoryDto> getSubCategoryById(
            @PathVariable Long categoryId,
            @PathVariable Long subcateId) {

        SubCategoryDto dto = subCategoryService.getSubCategoryByIdAndCategory(subcateId, categoryId);
        return ResponseEntity.ok(dto);
    }

    // Update SubCategory under a Category
    @PutMapping("/{categoryId}/subcategories/update/{subcateId}")
    public ResponseEntity<SubCategoryDto> updateSubCategory(
            @PathVariable Long categoryId,
            @PathVariable Long subcateId,
            @RequestBody SubCategoryDto dto) {

        dto.setCategoryId(categoryId);
        SubCategoryDto updated = subCategoryService.updateSubCategory(subcateId, dto);
        return ResponseEntity.ok(updated);
    }

    // Delete SubCategory under a Category
    @DeleteMapping("/{categoryId}/subcategories/del/{subcateId}")
    public ResponseEntity<String> deleteSubCategory(
            @PathVariable Long categoryId,
            @PathVariable Long subcateId) {

        subCategoryService.deleteSubCategoryByCategory(subcateId, categoryId);
        return ResponseEntity.ok("SubCategory deleted successfully!");
    }
}
