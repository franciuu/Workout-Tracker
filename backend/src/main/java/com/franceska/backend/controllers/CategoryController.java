package com.franceska.backend.controllers;

import com.franceska.backend.dto.CategoryResponse;
import com.franceska.backend.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryResponse> getCategories() {
        return categoryService.read();
    }
}
