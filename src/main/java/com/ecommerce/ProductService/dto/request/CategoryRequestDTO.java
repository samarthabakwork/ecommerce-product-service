package com.ecommerce.ProductService.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CategoryRequestDTO {
    @NotBlank(message = "Category name is required")
    private String name;
}
