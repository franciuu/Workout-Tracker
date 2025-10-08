package com.franceska.backend.services;

import com.franceska.backend.dto.ExerciseResponse;

import java.util.List;

public interface ExerciseService {
   List<ExerciseResponse> read();
}
