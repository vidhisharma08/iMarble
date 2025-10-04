package com.imarble.services;

import com.imarble.dto.SubCategoryDto;
import com.imarble.entities.Category;
import com.imarble.entities.SubCategory;
import com.imarble.mapper.SubCategoryMapper;
import com.imarble.repos.CategoryRepository;
import com.imarble.repos.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryMapper mapper;

    // Create SubCategory under a specific Category
    public SubCategoryDto createSubCategory(SubCategoryDto dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        SubCategory subCategory = mapper.toEntity(dto, category);
        SubCategory saved = subCategoryRepository.save(subCategory);
        return mapper.toDto(saved);
    }

    // Get all SubCategories of a Category
    public List<SubCategoryDto> getAllSubCategoriesByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        return subCategoryRepository.findAll()
                .stream()
                .filter(sc -> sc.getCategory().getCateid().equals(category.getCateid()))
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // Get SubCategory by ID under a Category
    public SubCategoryDto getSubCategoryByIdAndCategory(Long subcateId, Long categoryId) {
        SubCategory subCategory = subCategoryRepository.findById(subcateId)
                .orElseThrow(() -> new RuntimeException("SubCategory not found with id: " + subcateId));

        if (!subCategory.getCategory().getCateid().equals(categoryId)) {
            throw new RuntimeException("SubCategory does not belong to Category id: " + categoryId);
        }

        return mapper.toDto(subCategory);
    }

    // Update SubCategory under a Category
    public SubCategoryDto updateSubCategory(Long subcateId, SubCategoryDto dto) {
        SubCategory existing = subCategoryRepository.findById(subcateId)
                .orElseThrow(() -> new RuntimeException("SubCategory not found with id: " + subcateId));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        existing.setTitle(dto.getTitle());
        existing.setScdesc(dto.getScdesc());
        existing.setImage(dto.getImage());
        existing.setStatus(dto.getStatus());
        existing.setCategory(category);

        SubCategory updated = subCategoryRepository.save(existing);
        return mapper.toDto(updated);
    }

    // Delete SubCategory under a Category
    public void deleteSubCategoryByCategory(Long subcateId, Long categoryId) {
        SubCategory existing = subCategoryRepository.findById(subcateId)
                .orElseThrow(() -> new RuntimeException("SubCategory not found with id: " + subcateId));

        if (!existing.getCategory().getCateid().equals(categoryId)) {
            throw new RuntimeException("SubCategory does not belong to Category id: " + categoryId);
        }

        subCategoryRepository.delete(existing);
    }
}
