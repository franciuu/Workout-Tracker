package com.franceska.backend.repositories;

import com.franceska.backend.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long>, JpaSpecificationExecutor<ExerciseEntity> {
    List<ExerciseEntity> findByNameContainingIgnoreCase(String keyword);
    Optional<ExerciseEntity> findByExerciseId(String exerciseId);
}
