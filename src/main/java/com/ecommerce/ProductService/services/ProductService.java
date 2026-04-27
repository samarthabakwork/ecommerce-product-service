package com.ecommerce.ProductService.services;

import com.ecommerce.ProductService.dto.request.ProductRequestDTO;
import com.ecommerce.ProductService.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    List<ProductResponseDTO> searchProducts(String keyword);
    List<ProductResponseDTO> getProductsByCategory(Long categoryId);

    ProductResponseDTO createProduct(ProductRequestDTO request);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO request);
    void deleteProduct(Long id);
    ProductResponseDTO updateStock(Long id, Integer stock);
}
