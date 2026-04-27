package com.ecommerce.ProductService.controllers;

import com.ecommerce.ProductService.dto.request.ProductRequestDTO;
import com.ecommerce.ProductService.dto.response.ProductResponseDTO;
import com.ecommerce.ProductService.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;

    @PostMapping("/createproduct")
    public ResponseEntity<ProductResponseDTO> create(
            @Valid @RequestBody ProductRequestDTO request) {

        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<ProductResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {

        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product Deleted successfully");
    }

    @PatchMapping("/updatestock/{id}")
    public ResponseEntity<ProductResponseDTO> updateStock(
            @PathVariable Long id,
            @RequestBody Integer stock) {

        return ResponseEntity.ok(productService.updateStock(id, stock));
    }
}
