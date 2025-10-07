package com.franceska.backend.seeders;

import com.franceska.backend.entities.CategoryEntity;
import com.franceska.backend.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Configuration
@RequiredArgsConstructor
public class CategorySeeder implements ApplicationRunner {
    private final CategoryRepository categoryRepository;
    private final static Logger logger = Logger.getLogger(CategorySeeder.class.getName());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(args.getOptionValues("seeder") != null) {
            List<String> seeder = Arrays.asList(args.getOptionValues("seeder").getFirst().split(","));
            if(seeder.contains("category")) {
                seedCategories();
                logger.info("Category seeder executed");
            } else {
                logger.info("Category seeder skipped");
            }
        }
    }

    private void seedCategories() {
        List<CategoryEntity> categories = new ArrayList<>();
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Abs")
                .description("Exercises that target the abdominal muscles")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Back")
                .description("Exercises that target the back muscles")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Biceps")
                .description("Exercises that target the biceps muscles")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Cardio")
                .description("Exercises that increase heart rate and endurance")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Chest")
                .description("Exercises that target the chest muscles")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Forearms")
                .description("Exercises that target the forearm muscles")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Glutes")
                .description("Exercises that target the gluteal muscles")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Shoulders")
                .description("Exercises that target the shoulder muscles")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Triceps")
                .description("Exercises that target the triceps muscles")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Upper Legs")
                .description("Exercises that target the quadriceps and hamstrings")
                .build()
        );
        categories.add(CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name("Lower Legs")
                .description("Exercises that target the calves")
                .build()
        );

        for (var category : categories) {
            categoryRepository.save(category);
            logger.info("Success run CategorySeeder for " + category.getName());
        }
    }
}
