package com.ecommerce.ProductService.repositories;

import com.ecommerce.ProductService.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
