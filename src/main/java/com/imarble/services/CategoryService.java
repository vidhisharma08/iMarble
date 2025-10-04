package com.imarble.services;

import com.imarble.dto.CategoryDto;
import com.imarble.entities.Category;
import com.imarble.mapper.CategoryMapper;
import com.imarble.repos.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Create category
    public CategoryDto createCategory(CategoryDto dto) {
        Category category = CategoryMapper.toEntity(dto);
        return CategoryMapper.toDto(categoryRepository.save(category));
    }

    // Get all categories
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    // Get category by ID
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        return CategoryMapper.toDto(category);
    }

    // Update category
    public CategoryDto updateCategory(Long id, CategoryDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        category.setTitle(dto.getTitle());
        category.setCdesc(dto.getCdesc());
        category.setImage(dto.getImage());
        category.setStatus(dto.getStatus());

        return CategoryMapper.toDto(categoryRepository.save(category));
    }

    // Delete category
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        categoryRepository.delete(category);
    }
}
