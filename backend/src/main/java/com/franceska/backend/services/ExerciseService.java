package com.franceska.backend.services;

import com.franceska.backend.dto.ExerciseResponse;

import java.util.List;
import java.util.Map;

public interface ExerciseService {
   List<ExerciseResponse> read(Map<String, Object> filters);
}
