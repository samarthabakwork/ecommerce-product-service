package com.ecommerce.ProductService.services.category;

import com.ecommerce.ProductService.dto.request.CategoryRequestDTO;
import com.ecommerce.ProductService.dto.response.CategoryResponseDTO;
import com.ecommerce.ProductService.entities.Category;
import com.ecommerce.ProductService.exception.ResourceNotFoundException;
import com.ecommerce.ProductService.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;
    private final ModelMapper mapper;


    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {

        Category category = mapper.map(request, Category.class);
        Category saved = repo.save(category);

        return mapper.map(saved, CategoryResponseDTO.class);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO request) {

        Category category = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(request.getName());

        return mapper.map(repo.save(category), CategoryResponseDTO.class);
    }

    @Override
    public void deleteCategory(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return repo.findAll()
                .stream()
                .map(c -> mapper.map(c, CategoryResponseDTO.class))
                .toList();
    }
}
