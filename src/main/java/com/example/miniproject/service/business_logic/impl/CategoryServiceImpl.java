package com.example.miniproject.service.business_logic.impl;

import com.example.miniproject.dto.CategoriesListDTO;
import com.example.miniproject.dto.CategoryDTO;
import com.example.miniproject.entity.Category;
import com.example.miniproject.service.business_logic.CategoryService;
import com.example.miniproject.service.data_access.CategoryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryInfoService categoryInfoService;

    @Override
    public CategoriesListDTO getCategories() {

        List<Category> categories = categoryInfoService.getCategories();

        List<CategoryDTO> categoryDTOS = categories.stream().map(category ->
                CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build()
        ).toList();

        return CategoriesListDTO.builder()
                .categories(categoryDTOS)
                .build();
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        Category category = categoryInfoService.getCategory(id);

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

        Category category = categoryInfoService.addCategory(categoryDTO);

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO category) {

        Category updatedCategory = categoryInfoService.updateCategory(category);

        return CategoryDTO.builder()
                .id(updatedCategory.getId())
                .name(category.getName())
                .build();
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {

        Category category = categoryInfoService.deleteCategory(categoryId);

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
