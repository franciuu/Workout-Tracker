package com.franceska.backend.controllers;

import com.franceska.backend.dto.routine.RoutineRequest;
import com.franceska.backend.dto.routine.RoutineResponse;
import com.franceska.backend.repositories.RoutineRepository;
import com.franceska.backend.services.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoutineController {
    private final RoutineService routineService;
    @PostMapping("/routines")
    @ResponseStatus(HttpStatus.CREATED)
    public RoutineResponse addRoutine(@RequestBody RoutineRequest request) {
        return routineService.createRoutine(request);
    }
}
