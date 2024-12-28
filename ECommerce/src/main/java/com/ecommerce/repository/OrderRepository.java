package com.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ecommerce.models.Order;
import com.ecommerce.services.OrderProductDTO;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


	void deleteByUser_UsernameAndOrderId(String username, long id);
	
	 @Query("SELECT new com.ecommerce.services.OrderProductDTO(o.orderId,p.id, p.title,o.status,o.orderedDate,o.deliveryDate) FROM Order o " +
	           "JOIN o.product p " +
	           "WHERE o.user.username = :username")
	 List<OrderProductDTO> findOrdersByUsername(@Param("username") String username);
	
//	 @Query("select new com.ecommerce.services.OrderProductDTO(o.orderId,p.id, p.title,o.status,o.orderedDate,o.deliveryDate) " +
//	           "FROM Order o JOIN Product p ON o.product=  p.id " +
//	           "WHERE o.user= :username")
//	    List<OrderProductDTO> findOrderWithProduct(@Param("username") String username);

	 
//	    @Query("SELECT new com.ecommerce.services.OrderProductDTO(o.order_id,p.id, p.product_name,o.status,o.ordered_date,o.delivery_date) " +
//	           "FROM Order o JOIN Products p")
//	    List<OrderProductDTO> findAllOrdersWithProduct();
	    
	    ///ECommerce/src/main/java/com/ecommerce/services/OrderProductDTO.java
	    
	    @Query(" Select new com.ecommerce.services.OrderProductDTO(o.orderId,p.id, p.title,o.status,o.orderedDate,o.deliveryDate) FROM Order o JOIN o.product p ")  // Removed the WHERE clause
	     List<OrderProductDTO> findAllOrdersWithProducts();
}
