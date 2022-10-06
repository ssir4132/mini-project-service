package com.example.miniproject.service.data_access.impl;

import com.example.miniproject.dto.CategoryDTO;
import com.example.miniproject.entity.Category;
import com.example.miniproject.exception.ConflictResourceException;
import com.example.miniproject.exception.ResourceNotFoundException;
import com.example.miniproject.repository.CategoryRepo;
import com.example.miniproject.service.data_access.CategoryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryInfoServiceImpl implements CategoryInfoService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepo.findAll();

        if (categories.isEmpty()) throw new ResourceNotFoundException("Categories not found");

        return categories;
    }

    @Override
    public Category getCategory(Long categoryId) {

        Optional<Category> category = categoryRepo.findById(categoryId);

        if (category.isEmpty()) throw new ResourceNotFoundException("Category not found from given Id");

        return category.get();

    }

    @Override
    public Category addCategory(CategoryDTO categoryDTO) {

        Optional<Category> existingCategory = categoryRepo.findCategoryByName(categoryDTO.getName());

        if (existingCategory.isPresent()) throw new ConflictResourceException("Category Exists with given name");

        Category category = Category.builder()
                .name(categoryDTO.getName())
                .build();

        return categoryRepo.save(category);

    }

    @Override
    public Category updateCategory(CategoryDTO category) {

        Optional<Category> existingCategory = categoryRepo.findById(category.getId());

        if (existingCategory.isEmpty()) throw new ResourceNotFoundException("Category not found from given Id");

        existingCategory.get().setName(category.getName());

        return categoryRepo.save(existingCategory.get());

    }

    @Override
    public Category deleteCategory(Long categoryId) {

        Optional<Category> existingCategory = categoryRepo.findById(categoryId);

        if (existingCategory.isEmpty()) throw new ResourceNotFoundException("Category not found from given Id");

        categoryRepo.delete(existingCategory.get());

        return existingCategory.get();
    }
}

