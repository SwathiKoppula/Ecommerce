package com.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ecommerce.models.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

//	<named-query name="findByCategory">
//	  <query>select category_name from category</query>
//	</named-query>
	
	@Query("SELECT c.categoryName FROM Category c")
	List<String> findAllCategoryNames();
	
//	 @Query("SELECT c.categoryName FROM Category c")
//	    List<String> findAllCategoryNames();
	
	Category findByCategoryName(String categoryName);

	void deleteByCategoryName(String categoryName);
}
