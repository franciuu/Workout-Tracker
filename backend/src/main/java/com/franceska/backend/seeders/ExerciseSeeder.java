package com.franceska.backend.seeders;

import com.franceska.backend.entities.CategoryEntity;
import com.franceska.backend.entities.ExerciseEntity;
import com.franceska.backend.repositories.CategoryRepository;
import com.franceska.backend.repositories.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.logging.Logger;

@Configuration
@RequiredArgsConstructor
public class ExerciseSeeder implements ApplicationRunner {
    private final ExerciseRepository exerciseRepository;
    private final CategoryRepository categoryRepository;
    private final static Logger logger = Logger.getLogger(ExerciseSeeder.class.getName());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(args.getOptionValues("seeder") != null) {
            List<String> seeder = Arrays.asList(args.getOptionValues("seeder").getFirst().split(","));
            if(seeder.contains("exercise")) {
                seedExercises();
                logger.info("Exercise seeder executed");
            } else {
                logger.info("Exercise seeder skipped");
            }
        }
    }

    private void seedExercises() {
        CategoryEntity abs = categoryRepository.findByName("Abs");
        CategoryEntity back = categoryRepository.findByName("Back");
        CategoryEntity biceps = categoryRepository.findByName("Biceps");
        CategoryEntity cardio = categoryRepository.findByName("Cardio");
        CategoryEntity chest = categoryRepository.findByName("Chest");
        CategoryEntity forearms = categoryRepository.findByName("Forearms");
        CategoryEntity glutes = categoryRepository.findByName("Glutes");
        CategoryEntity shoulders = categoryRepository.findByName("Shoulders");
        CategoryEntity triceps = categoryRepository.findByName("Triceps");
        CategoryEntity upper = categoryRepository.findByName("Upper Legs");
        CategoryEntity lower = categoryRepository.findByName("Lower Legs");

        List<ExerciseEntity> exercises = new ArrayList<>();

        exercises.add(ExerciseEntity.builder()
                .exerciseId(UUID.randomUUID().toString())
                .name("Barbell Bench Press")
                .description("""
Lie flat on a bench, grip the bar slightly wider than shoulder-width, and unrack it. 
Lower to mid-chest, then press back up, keeping elbows at about 45°. Avoid bouncing the bar off your chest.
""")
                .videoUrl("https://cbstwmlblgfowgoejqls.supabase.co/storage/v1/object/public/fitness-tracker/BarbellBenchPress.gif")
                        .categories(Set.of(chest, triceps, shoulders))
                .build()
        );


        exercises.add(ExerciseEntity.builder()
                .exerciseId(UUID.randomUUID().toString())
                .name("Barbell Curl")
                .description("""
Stand straight holding the barbell with an underhand grip. 
Curl it toward your chest while keeping elbows close. 
Avoid swinging your body and lower slowly to starting position.
""")
                .videoUrl("https://cbstwmlblgfowgoejqls.supabase.co/storage/v1/object/public/fitness-tracker/BarbellCurl.gif")
                .categories(Set.of(biceps))
                .build()
        );

        exercises.add(ExerciseEntity.builder()
                .exerciseId(UUID.randomUUID().toString())
                .name("Dumbbell Lateral Raise")
                .description("""
Stand tall holding dumbbells at your sides. 
Raise arms out until shoulder height, elbows slightly bent, palms down. 
Control the motion—avoid swinging—and lower slowly.
""")
                .videoUrl("https://cbstwmlblgfowgoejqls.supabase.co/storage/v1/object/public/fitness-tracker/DumbbellLateralRaise.gif")
                .categories(Set.of(shoulders))
                .build()
        );

        for (var exercise : exercises) {
            exerciseRepository.save(exercise);
            logger.info("Success run ExerciseSeeder for " + exercise.getName());
        }
    }
}
