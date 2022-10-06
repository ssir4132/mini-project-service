package com.example.miniproject.service.business_logic;

import com.example.miniproject.dto.CategoriesListDTO;
import com.example.miniproject.dto.CategoryDTO;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    CategoriesListDTO getCategories();

    CategoryDTO getCategory(Long id);

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO category);

    CategoryDTO deleteCategory(Long categoryId);
}
