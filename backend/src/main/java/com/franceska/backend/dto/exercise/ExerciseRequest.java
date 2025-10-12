package com.franceska.backend.dto.exercise;

import com.franceska.backend.entities.CategoryEntity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExerciseRequest {
    private String name;
    private String description;
    private String videoUrl;
    private Set<CategoryEntity> categories = new HashSet<>();
}
