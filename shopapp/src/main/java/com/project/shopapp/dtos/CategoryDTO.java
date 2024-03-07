package com.project.shopapp.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDTO {
    @NotEmpty(message = "Category's name can't be empty")
    private String name;
}
