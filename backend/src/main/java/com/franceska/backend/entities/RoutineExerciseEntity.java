package com.franceska.backend.entities;

import com.franceska.backend.entities.ids.RoutineExerciseId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "routine_exercise",
        uniqueConstraints = @UniqueConstraint(columnNames = {"routine_id", "exercise_id"}))
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@IdClass(RoutineExerciseId.class)
public class RoutineExerciseEntity {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "routine_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private RoutineEntity routine;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "exercise_id", nullable = false)
    private ExerciseEntity exercise;

    private Integer sets;
    private Integer reps;
    private Integer weight;
    private Integer orderIndex;
}
