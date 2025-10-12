package com.franceska.backend.dto.category;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequest {
    private String name;
    private String description;
}
