package com.franceska.backend.mappers;

import com.franceska.backend.dto.exercise.ExerciseResponse;
import com.franceska.backend.entities.CategoryEntity;
import com.franceska.backend.entities.ExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    @Mapping(target = "categoriesNames", source = "categories")
    ExerciseResponse toResponse(ExerciseEntity exercise);

    default Set<String> mapCategories(Set<CategoryEntity> categories) {
        if(categories == null) {
            return Collections.emptySet();
        }
        return categories.stream()
                .map(CategoryEntity::getName)
                .collect(Collectors.toSet());
    }
}
