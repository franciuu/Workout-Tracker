package com.franceska.backend.services.impl;

import com.franceska.backend.dto.routine.RoutineRequest;
import com.franceska.backend.dto.routine.RoutineResponse;
import com.franceska.backend.entities.RoutineEntity;
import com.franceska.backend.mappers.RoutineMapper;
import com.franceska.backend.repositories.RoutineRepository;
import com.franceska.backend.services.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService {
    private final RoutineRepository routineRepository;
    private final RoutineMapper routineMapper;
    @Override
    public RoutineResponse createRoutine(RoutineRequest request) {
        RoutineEntity newRoutine = routineMapper.toEntity(request);
        newRoutine = routineRepository.save(newRoutine);
        return routineMapper.toResponse(newRoutine);
    }

    @Override
    public List<RoutineResponse> getAllRoutines() {
        List<RoutineEntity> existingRoutines = routineRepository.findAll();
        return existingRoutines.stream()
                .map(routineMapper::toResponse)
                .collect(Collectors.toList());
    }
}
