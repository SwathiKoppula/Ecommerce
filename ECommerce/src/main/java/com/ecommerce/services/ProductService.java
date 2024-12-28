package com.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Category;
import com.ecommerce.models.Product;
import com.ecommerce.models.ProductAddRequest;
import com.ecommerce.models.ProductRequest;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CategoryService categoryService;

	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	public List<Product> getAllByCategory(String category){
		long categoryId = categoryService.getCategoryId(category);
		List<Product> resultList = productRepository.findProductsByCategoryId(categoryId);
		return resultList;
	}
	
	public Product getProductById(long id) {
		Product product = productRepository.findById(id);
		return product;
	}
	
	
	public List<Product> getProductById(List<Long> id) {
		List<Product> product = productRepository.findByIdIn(id);
		return product;
	}

	public void addNewProduct(ProductAddRequest productRequest) {
		Product product = new Product();
		Category category = categoryService.getCategory(productRequest.getCategoryname());
		product.setCategory(category);
		product.setDescription(productRequest.getDescription());
		product.setImageUrl(productRequest.getImageUrl());
		product.setPrice(productRequest.getPrice());
		product.setReviews(productRequest.getReviews());
		product.setTitle(productRequest.getTitle());
		productRepository.save(product);
	}

	public void deleteProduct(long productId) {
	    productRepository.deleteById(productId);
	}

	public void updateProductById(long id, ProductRequest productRequest) {
		Product product =  (Product) productRepository.findById(id);
	            product.setDescription(productRequest.getDescription());
	            product.setPrice(productRequest.getPrice());
		        productRepository.save(product);
	}
	
	
	
}
