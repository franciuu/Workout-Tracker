package com.franceska.backend.dto.routine;

import com.franceska.backend.dto.exercise.ExerciseResponse;
import com.franceska.backend.dto.routineExercise.RoutineExerciseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineResponse {
    private String routineId;
    private String name;
    private Set<RoutineExerciseResponse> exercises = new HashSet<>();
}
