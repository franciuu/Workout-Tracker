package com.franceska.backend.dto.exercise;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExerciseResponse {
    private String exerciseId;
    private String name;
    private String description;
    private String videoUrl;
    private Set<String> categoriesNames = new HashSet<>();
}
