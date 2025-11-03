package com.franceska.backend.controllers;

import com.franceska.backend.dto.routine.RoutineRequest;
import com.franceska.backend.dto.routine.RoutineResponse;
import com.franceska.backend.repositories.RoutineRepository;
import com.franceska.backend.services.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class RoutineController {
    private final RoutineService routineService;
    @PostMapping("/routines")
    @ResponseStatus(HttpStatus.CREATED)
    public RoutineResponse addRoutine(@RequestBody RoutineRequest request) {
        return routineService.createRoutine(request);
    }

    @GetMapping("/routines")
    public List<RoutineResponse> getAllRoutines() {
        return routineService.getAllRoutines();
    }
}
