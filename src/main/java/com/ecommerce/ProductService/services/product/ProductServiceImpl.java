package com.ecommerce.ProductService.services.product;

import com.ecommerce.ProductService.dto.request.ProductRequestDTO;
import com.ecommerce.ProductService.dto.response.ProductResponseDTO;
import com.ecommerce.ProductService.entities.Category;
import com.ecommerce.ProductService.entities.Product;
import com.ecommerce.ProductService.exception.ResourceNotFoundException;
import com.ecommerce.ProductService.repositories.CategoryRepository;
import com.ecommerce.ProductService.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final ModelMapper mapper;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(product -> mapper.map(product, ProductResponseDTO.class))
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product p = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return mapper.map(p, ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> searchProducts(String keyword) {
        return productRepo.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(product->mapper.map(product,ProductResponseDTO.class))
                .toList();
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(Long categoryId) {
        return productRepo.findByCategoryId(categoryId)
                .stream()
                .map(product -> mapper.map(product, ProductResponseDTO.class))
                .toList();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO request) {

        Category category = categoryRepo.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Product product = mapper.map(request, Product.class);
        product.setId(null);
        product.setCategory(category);

        return mapper.map(productRepo.save(product), ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Category category = categoryRepo.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(category);

        return mapper.map(productRepo.save(product), ProductResponseDTO.class);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepo.deleteById(id);
    }

    @Override
    public ProductResponseDTO updateStock(Long id, Integer stock) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product.setStock(stock);
        return mapper.map(productRepo.save(product), ProductResponseDTO.class);
    }

}
