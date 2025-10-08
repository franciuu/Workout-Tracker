package com.franceska.backend.controllers;

import com.franceska.backend.dto.ExerciseResponse;
import com.franceska.backend.services.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("/exercises")
    public List<ExerciseResponse> getAllExercises() {
        return exerciseService.read();
    }
}
