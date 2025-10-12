package com.franceska.backend.dto.routineExercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineExerciseResponse {
    private String exerciseId;
    private String exerciseName;
    private Integer sets;
    private Integer reps;
}
