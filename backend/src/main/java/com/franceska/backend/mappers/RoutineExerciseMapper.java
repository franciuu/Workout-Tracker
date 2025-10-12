package com.franceska.backend.mappers;

import com.franceska.backend.dto.routineExercise.RoutineExerciseRequest;
import com.franceska.backend.dto.routineExercise.RoutineExerciseResponse;
import com.franceska.backend.entities.RoutineExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RoutineExerciseMapper {

    @Mapping(target = "routine", ignore = true) //se seteaza in RoutineMapping
    @Mapping(target = "exercise", ignore = true)
    public abstract RoutineExerciseEntity toEntity(RoutineExerciseRequest request);

    @Mapping(target = "exerciseId", source = "exercise.exerciseId")
    @Mapping(target = "exerciseName", source = "exercise.name")
    public abstract RoutineExerciseResponse toResponse(RoutineExerciseEntity entity);
}
