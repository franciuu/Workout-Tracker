package com.franceska.backend.dto;

import com.franceska.backend.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseRequest {
    private String name;
    private String description;
    private String videoUrl;
    private Set<CategoryEntity> categories = new HashSet<>();
}
