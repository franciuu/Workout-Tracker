package com.franceska.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExerciseResponse {
    private String exerciseId;
    private String name;
    private String description;
    private String videoUrl;
    private Set<String> categoriesNames = new HashSet<>();
}
