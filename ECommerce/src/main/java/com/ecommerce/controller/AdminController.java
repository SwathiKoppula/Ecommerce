package com.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.models.Category;
import com.ecommerce.models.LoginRequest;
import com.ecommerce.models.Product;
import com.ecommerce.models.ProductAddRequest;
import com.ecommerce.models.ProductRequest;
import com.ecommerce.models.User;
import com.ecommerce.services.AdminService;
import com.ecommerce.services.CategoryService;
import com.ecommerce.services.OrderProductDTO;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.UserService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	 private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("login")
	public String login(@RequestBody LoginRequest loginRequest){
		try {
			if(adminService.validateLogin(loginRequest).equals("Athunticate")) {
			   return "Athunticate";
		}
			else {
				return "NOT AUTHENTICATED";
			}
	}			
		catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("users/all")
	public List<User> getUserDetails(){
         List<User> users= userService.getAllusers();
		return users;   
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable long id){
          userService.deleteUser(id);		
	}
	
	@GetMapping("orders/all")
	public List<OrderProductDTO> getAllOrders(){
		List<OrderProductDTO> orders = orderService.getOders();
		return orders;
		
	}
	
	@DeleteMapping("orders/{id}")
	public void deleteOrder(@PathVariable long id){
		orderService.deleteById(id);
	}
	
	@GetMapping("products/all")
	public List<Product> getProduct(){
		List<Product> products = productService.getAllProducts();
		return products;
	}
	
	@PostMapping("/product/add")
	public void addProduct(@RequestBody ProductAddRequest productRequest) {
		productService.addNewProduct(productRequest);
	}
	
	@DeleteMapping("/product/{productId}")
	public void deleteProduct(@PathVariable long productId) {
		productService.deleteProduct(productId);
	}
	
	@PatchMapping("products/update/{id}")
	public void updateProduct(@PathVariable long id, @RequestBody ProductRequest productRequest) {
		productService.updateProductById(id,productRequest);
	}
	
	@PostMapping("categories/add")
	public String addcategorie(@RequestBody String categoey) {
		categoryService.addCategory(categoey);
		return "category added";
	}
	
	@DeleteMapping("category/delete/{id}")
	public void deleteCategories(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}
	
	@DeleteMapping("category/delete/name/{categoryName}")
	public void deleteCategories(@PathVariable String categoryName) {
		categoryService.deleteCategoryByName(categoryName);
	}
	
	@GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
	
}
