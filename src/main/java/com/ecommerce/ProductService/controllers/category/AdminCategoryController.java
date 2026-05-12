package com.ecommerce.ProductService.controllers.category;

import com.ecommerce.ProductService.dto.request.CategoryRequestDTO;
import com.ecommerce.ProductService.dto.response.CategoryResponseDTO;
import com.ecommerce.ProductService.dto.response.MessageResponseDTO;
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

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryResponseDTO> create(
            @Valid @RequestBody CategoryRequestDTO request) {

        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<CategoryResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDTO request) {

        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<MessageResponseDTO> delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new MessageResponseDTO("Category Deleted successfully",true));
    }
}
