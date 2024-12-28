package com.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.models.Cart;
import com.ecommerce.models.CartProductDto;
import com.ecommerce.models.LoginRequest;
import com.ecommerce.models.Product;
import com.ecommerce.models.RegisterRequest;
import com.ecommerce.models.User;
import com.ecommerce.services.CartService;
import com.ecommerce.services.CategoryService;
import com.ecommerce.services.OrderProductDTO;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	 private ProductService productService;
	
	@Autowired
	 private CategoryService categoryService;
	
	@Autowired
	 private CartService cartService;

	@Autowired
	OrderService orderService;
	
	//USERS AUTHENTICATE
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest,HttpServletResponse res){
		System.out.println("------------------------------------------------------");
		System.out.println("username"+loginRequest.getUsername()+"password"+loginRequest.getPassword());
		try {
			if(userService.validateLogin(loginRequest)) {
//			  res.addCookie(new Cookie("username", loginRequest.getUsename()));
			   return loginRequest.getUsername();
		}
			else {
				return "Wrong Credentials Check Again";
			}
	}			
		catch (Exception e) {
			return " Server Error";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest res,HttpServletResponse response) {
		String userName = userService.getUserName(res);
		if(userName == null) {
			return "login";
		}
		else {
			userService.logoutUser(userName,response);
		}
		return null;
	}

	
	@GetMapping("home")
	public String userlogin(Model model) {
		return "Home.html";
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
		System.out.println("------------------------------------------------------");
		System.out.println("username"+registerRequest.getUsername()+"password"+registerRequest.getPassword());
		if (registerRequest.getUsername() == null || registerRequest.getUsername().isEmpty()) {
	        return ResponseEntity.badRequest().body("Username cannot be null or empty");
	    }
		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setPassword(registerRequest.getPassword());
		user.setEmail(registerRequest.getEmail());
		user.setAddress(registerRequest.getAddress());
		user.setMobileNo(registerRequest.getMobileno());
        user.setRole("user"); // Default role
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	//PRODUCTS AND CATEGORIES
	
	@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
	
	 @GetMapping("products/{category}")
	    public List<Product> getProductById(@PathVariable String category) {
	        return productService.getAllByCategory(category);
	    }
	 
	 
	 @GetMapping("/categoriesNames")
	    public List<String> getAllCategories() {
	        return categoryService.getCategories();
	    }
	 
	 // CART METHODS
	 
	 @GetMapping("cart/{username}")
	 public List<CartProductDto> getItems(@PathVariable String username){
		
		 List<CartProductDto> cartByUsename = cartService.getCartByUsename(username);
		return cartByUsename;
	 }
	 
	 @PostMapping("cart/{username}/{productId}")
	 public String addtocart(@PathVariable String username, @PathVariable Long productId) {
		 Cart cart = new Cart();
		 Product product = productService.getProductById(productId);
		 User user = userService.getUser(username);
		 cart.setProduct(product);
		 cart.setUser(user);
		 return cartService.addToCart(cart);
	 }
	 
	 @DeleteMapping("cart/delete/{cartId}")
	 public void deleteitem(@PathVariable long cartId) {
		 cartService.deleteItem(cartId);
	 }
	 
	 @PatchMapping("cart/update/{cartId}")
	 public String updateCart(@PathVariable long id, @RequestBody int quantity) {
		 cartService.cartUpdate(id,quantity);
		 return "Cart Updated";
	 }
	 
	 
	 //CHECK OUT 
	 
	 @PostMapping("placeOrder/{username}/{id}")
	 public String placeOrder(@PathVariable String username, @PathVariable long id) {
		  orderService.placeOrder(username,id);
		return "Ordered Places";
	 }
	 
	 @DeleteMapping("orders/{username}/{id}")
	 public void deleteOder(@PathVariable String username, @PathVariable long id) {
		 orderService.removeOrder(username, id);
	 }
	 
	 @GetMapping("orders/{username}")
	 public List<OrderProductDTO> getOrders(@PathVariable String username){
		 List<OrderProductDTO> orderedItems = orderService.getOrderedItems(username);
		return orderedItems;
	 }
	 
}
