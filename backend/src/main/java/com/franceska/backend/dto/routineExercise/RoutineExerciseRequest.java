package com.franceska.backend.dto.routineExercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineExerciseRequest {
    private String exerciseId;
    private Integer sets;
    private Integer reps;
    private Integer weight;
    private Integer orderIndex;
}
