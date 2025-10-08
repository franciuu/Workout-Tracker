package com.franceska.backend.services;

import com.franceska.backend.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> read();
}
