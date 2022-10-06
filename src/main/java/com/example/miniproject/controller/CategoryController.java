package com.example.miniproject.controller;

import com.example.miniproject.dto.CategoriesListDTO;
import com.example.miniproject.dto.CategoryDTO;
import com.example.miniproject.service.business_logic.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<CategoriesListDTO> getCategories() {

        CategoriesListDTO categoriesListDTO = categoryService.getCategories();

        return new ResponseEntity<>(categoriesListDTO, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<CategoryDTO> addCategory(
            @RequestBody CategoryDTO categoryDTO
    ) {

        CategoryDTO category = categoryService.addCategory(categoryDTO);

        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable("id")
            @NotNull(message = "Category Id cannot be empty")
            Long categoryId,
            @RequestBody CategoryDTO categoryDTO
    ) {
        categoryDTO.setId(categoryId);
        CategoryDTO category = categoryService.updateCategory(categoryDTO);

        return new ResponseEntity<>(category, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> deleteCategory(
            @PathVariable("id")
            @NotNull(message = "Category Id cannot be empty")
            Long categoryId
    ) {
        CategoryDTO category = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
