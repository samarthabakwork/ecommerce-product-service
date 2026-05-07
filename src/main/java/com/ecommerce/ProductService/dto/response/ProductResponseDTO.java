package com.ecommerce.ProductService.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    private Long categoryId;
    private String categoryName;
}
