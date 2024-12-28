package com.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Cart;
import com.ecommerce.models.CartProductDto;
import com.ecommerce.models.Product;
import com.ecommerce.repository.CartRepository;

@Service
public class CartService {
	
	 @Autowired
	 CartRepository cartRepository;
	 
	 @Autowired
	 ProductService productService;

	public List<CartProductDto> getCartByUsename(String userName){
		 
		List<CartProductDto> cart = cartRepository.findCartByUsername(userName);
//		List<Product> cartProduct = productService.getProductById(cart);
		return cart;
	}
	
	
	public void deleteItem(long id) {
		
		cartRepository.deleteById(id);
	}
	
	public String addToCart(Cart cart) {
		Product product = cart.getProduct();
		//if(cartRepository.existsByProcductId(product.getId())) 
		if(cartRepository.existsByProduct(product)) {
			 return "Product alredy present in Cart";
		}
		else {
		cartRepository.save(cart);
		return "added";
		}
	}

	public void cartUpdate(long id, int quantity) {
		Cart cart = cartRepository.findById(id);
		cart.setQuantity(quantity);
		cartRepository.save(cart);
	}
}
