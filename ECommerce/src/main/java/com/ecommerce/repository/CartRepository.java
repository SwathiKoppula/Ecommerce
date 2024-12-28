package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ecommerce.models.Cart;
import com.ecommerce.models.CartProductDto;
import com.ecommerce.models.Product;


public interface CartRepository extends JpaRepository<Cart, Long> {
		 
	 @Query("SELECT new com.ecommerce.models.CartProductDto(c.id,p.id,p.title,p.price,p.reviews,p.description,p.imageUrl) FROM Cart c JOIN c.product p WHERE c.user.username = :username")
	 List<CartProductDto> findCartByUsername(@Param("username") String username);
	 
	 @Query("SELECT c.id FROM Cart c WHERE c.product = :productId")
	 Long findCartIdByProductId(@Param("productId") Long productId);

	void save(Optional<Product> product);
	
	boolean existsByProduct(Product product);
	
	Cart findById(long id);
	
	
	//@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Cart c WHERE c.product.id = :productId")
	//boolean existsProductByIdInCart(@Param("productId") Long productId);
	
	
	
	
	

}
