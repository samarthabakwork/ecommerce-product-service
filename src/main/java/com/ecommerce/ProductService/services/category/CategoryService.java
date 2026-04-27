package com.ecommerce.ProductService.services.category;


import com.ecommerce.ProductService.dto.request.CategoryRequestDTO;
import com.ecommerce.ProductService.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO request);
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO request);
    void deleteCategory(Long id);

    List<CategoryResponseDTO> getAllCategories();
}
