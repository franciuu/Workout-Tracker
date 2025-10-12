package com.franceska.backend.entities.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineExerciseId implements Serializable {
    private Long routine;
    private Long exercise;
}
