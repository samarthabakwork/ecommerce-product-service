package com.ecommerce.ProductService.controllers.product;

import com.ecommerce.ProductService.dto.request.ProductRequestDTO;
import com.ecommerce.ProductService.dto.response.MessageResponseDTO;
import com.ecommerce.ProductService.dto.response.ProductResponseDTO;
import com.ecommerce.ProductService.services.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponseDTO> create(
            @Valid @RequestBody ProductRequestDTO request) {

        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {

        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<MessageResponseDTO> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(new MessageResponseDTO("Product Deleted successfully",true));
    }

    @PatchMapping("/updateStock/{id}")
    public ResponseEntity<ProductResponseDTO> updateStock(
            @PathVariable Long id,
            @RequestBody Integer stock) {

        return ResponseEntity.ok(productService.updateStock(id, stock));
    }
}
