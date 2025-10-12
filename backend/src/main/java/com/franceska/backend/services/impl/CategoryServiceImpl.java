package com.franceska.backend.services.impl;

import com.franceska.backend.dto.category.CategoryResponse;
import com.franceska.backend.entities.CategoryEntity;
import com.franceska.backend.repositories.CategoryRepository;
import com.franceska.backend.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponse> read() {
        List<CategoryEntity> existingCategories = categoryRepository.findAll();
        return existingCategories.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    private CategoryResponse convertToResponse(CategoryEntity categoryEntity) {
        return CategoryResponse.builder()
                .categoryId(categoryEntity.getCategoryId())
                .name(categoryEntity.getName())
                .description(categoryEntity.getDescription())
                .build();
    }
}
