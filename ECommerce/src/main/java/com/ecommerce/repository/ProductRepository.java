package com.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.models.Category;
import com.ecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	 List<Product> findByCategory(Category category);
	 
	 @Query("SELECT p FROM Product p WHERE p.category = :category")
	 List<Product> findProductsByCategory(@Param("category") Category category);
	 
	 @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
	 List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);
	
//	List<Product> findById(List<Long> id);
	List<Product> findByIdIn(List<Long> id);
	
	Product findById(long id);
}

