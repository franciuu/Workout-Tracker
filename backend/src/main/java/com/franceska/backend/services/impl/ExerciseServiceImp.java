package com.franceska.backend.services.impl;

import com.franceska.backend.dto.CategoryResponse;
import com.franceska.backend.dto.ExerciseResponse;
import com.franceska.backend.entities.CategoryEntity;
import com.franceska.backend.entities.ExerciseEntity;
import com.franceska.backend.repositories.ExerciseRepository;
import com.franceska.backend.services.ExerciseService;
import com.franceska.backend.specification.GenericSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImp implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    @Override
    public List<ExerciseResponse> read(Map<String, Object> filters) {
        List<ExerciseEntity> existingExercises = exerciseRepository.findAll(new GenericSpecification<>(filters));

        return existingExercises.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private ExerciseResponse convertToResponse(ExerciseEntity exerciseEntity) {
        return ExerciseResponse.builder()
                .exerciseId(exerciseEntity.getExerciseId())
                .name(exerciseEntity.getName())
                .description(exerciseEntity.getDescription())
                .videoUrl(exerciseEntity.getVideoUrl())
                .categoriesNames(convert(exerciseEntity))
                .build();
    }

    private static Set<String> convert(ExerciseEntity exerciseEntity) {
        return exerciseEntity.getCategories()
                .stream()
                .map(CategoryEntity::getName)
                .collect(Collectors.toSet());
    }
}
