package com.ecommerce.ProductService.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductRequestDTO {
    @NotBlank(message = "Product Name is required")
    private String name;

    private String description;

    @NotNull(message = "price is required")
    @Positive
    private Double price;

    @NotNull(message = "stock is required")
    private Integer stock;

    @NotNull(message = "categoryId is required")
    private Long categoryId;



}
