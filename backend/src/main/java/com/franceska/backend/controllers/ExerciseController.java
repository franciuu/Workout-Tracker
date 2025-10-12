package com.franceska.backend.controllers;

import com.franceska.backend.dto.exercise.ExerciseResponse;
import com.franceska.backend.services.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping("/exercises")
    public List<ExerciseResponse> getAllExercises(@RequestBody Map<String, Object> filters) {
        return exerciseService.read(filters);
    }
}
