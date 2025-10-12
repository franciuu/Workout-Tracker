package com.franceska.backend.services;

import com.franceska.backend.dto.routine.RoutineRequest;
import com.franceska.backend.dto.routine.RoutineResponse;


public interface RoutineService {
    RoutineResponse createRoutine(RoutineRequest request);
}
