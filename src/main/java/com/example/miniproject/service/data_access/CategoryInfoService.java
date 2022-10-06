package com.example.miniproject.service.data_access;

import com.example.miniproject.dto.CategoryDTO;
import com.example.miniproject.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryInfoService {

    List<Category> getCategories();

    Category getCategory(Long id);

    Category addCategory(CategoryDTO categoryDTO);

    Category updateCategory(CategoryDTO category);

    Category deleteCategory(Long categoryId);

}
