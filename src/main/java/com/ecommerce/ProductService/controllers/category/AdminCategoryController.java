package com.ecommerce.ProductService.controllers.category;

import com.ecommerce.ProductService.dto.request.CategoryRequestDTO;
import com.ecommerce.ProductService.dto.response.CategoryResponseDTO;
import com.ecommerce.ProductService.services.category.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PostMapping("/createcategory")
    public ResponseEntity<CategoryResponseDTO> create(
            @Valid @RequestBody CategoryRequestDTO request) {

        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @PutMapping("/updatecategory/{id}")
    public ResponseEntity<CategoryResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDTO request) {

        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/deletecategory/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category Deleted successfully");
    }
}
