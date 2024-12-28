package com.ecommerce.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.models.Order;
import com.ecommerce.models.Product;
import com.ecommerce.models.User;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;

	public void placeOrder(String username, long id) {
		 Product product = productService.getProductById(id);
		 User user = userService.getUser(username);
		 Order order = new Order();
		 order.setUser(user);
		 order.setProduct(product);
		 order.setOrderedDate(LocalDate.now());
		 order.setDeliverDate(LocalDate.now().plusDays(4));
		 order.setStatus("shipping");
		  orderRepository.save(order);
	}
	
	public List<OrderProductDTO> getOrderedItems(String username){
		List<OrderProductDTO> byUsername = orderRepository.findOrdersByUsername(username);
		return byUsername;
	}
	
	public void removeOrder(String username, long id) {
		orderRepository.deleteByUser_UsernameAndOrderId(username,id);
	}
	

	public List<OrderProductDTO> getOders() {
		return orderRepository.findAllOrdersWithProducts();
		
		}

	public void deleteById(long id) {
		orderRepository.deleteById(id);
	}
}
