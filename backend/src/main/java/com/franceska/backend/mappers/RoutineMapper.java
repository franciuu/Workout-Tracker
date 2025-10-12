package com.franceska.backend.mappers;
import com.franceska.backend.dto.routine.RoutineRequest;
import com.franceska.backend.dto.routine.RoutineResponse;
import com.franceska.backend.dto.routineExercise.RoutineExerciseRequest;
import com.franceska.backend.dto.routineExercise.RoutineExerciseResponse;
import com.franceska.backend.entities.ExerciseEntity;
import com.franceska.backend.entities.RoutineEntity;
import com.franceska.backend.entities.RoutineExerciseEntity;
import com.franceska.backend.entities.UserEntity;
import com.franceska.backend.repositories.ExerciseRepository;
import com.franceska.backend.repositories.UserRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
@Mapper(componentModel = "spring", uses = {RoutineExerciseMapper.class}, builder = @Builder(disableBuilder = true))
public abstract class RoutineMapper {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private RoutineExerciseMapper routineExerciseMapper;
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "routineId", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "exercises", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract RoutineEntity toEntity(RoutineRequest request);
    public abstract RoutineResponse toResponse(RoutineEntity entity);
    @AfterMapping
    protected void mapUserAndExercises(RoutineRequest request, @MappingTarget RoutineEntity entity) {

        if (request.getUserId() != null) {
            entity.setUser(mapUser(request.getUserId()));
        }
        if (request.getExercises() != null && !request.getExercises().isEmpty()) {
            Set<RoutineExerciseEntity> exerciseEntities = new HashSet<>();
            for (RoutineExerciseRequest exReq : request.getExercises()) {
                RoutineExerciseEntity exEntity = routineExerciseMapper.toEntity(exReq);
                ExerciseEntity exercise = exerciseRepository.findByExerciseId(exReq.getExerciseId())
                        .orElseThrow(() -> new RuntimeException("Exercise not found: " + exReq.getExerciseId()));
                exEntity.setExercise(exercise);
                exEntity.setRoutine(entity);
                exerciseEntities.add(exEntity);
            }
            entity.setExercises(exerciseEntities);

            System.out.println("Mapped " + exerciseEntities.size() + " exercises to routine " + entity.getRoutineId());
        }
    }
    protected UserEntity mapUser(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
    }
}