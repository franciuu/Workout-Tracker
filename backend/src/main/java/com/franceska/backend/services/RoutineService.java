package com.franceska.backend.services;

import com.franceska.backend.dto.routine.RoutineRequest;
import com.franceska.backend.dto.routine.RoutineResponse;

import java.util.List;


public interface RoutineService {
    RoutineResponse createRoutine(RoutineRequest request);
    List<RoutineResponse> getAllRoutines();
}
