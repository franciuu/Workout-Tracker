package com.franceska.backend.dto.routine;

import com.franceska.backend.dto.routineExercise.RoutineExerciseRequest;
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
public class RoutineRequest {
    private String name;
    private Set<RoutineExerciseRequest> exercises = new HashSet<>();
    private String userId;
}
