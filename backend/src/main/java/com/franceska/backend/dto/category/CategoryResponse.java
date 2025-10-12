package com.franceska.backend.dto.category;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {
    private String categoryId;
    private String name;
    private String description;
}
