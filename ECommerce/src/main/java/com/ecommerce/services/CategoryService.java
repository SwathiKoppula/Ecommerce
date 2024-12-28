package com.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.models.Category;
import com.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	

//	public List<Category> getCategories() {
//		
//		List<Category> result = categoryRepository.findAll();
//		return result;
//	}
	
	public List<String> getCategories() {
		List<String> categoryNames = categoryRepository.findAllCategoryNames();
		return categoryNames;
	}
	
	
	public void addCategory(String Category) {
		Category category = new Category();
		category.setCategoryName(Category);
		categoryRepository.save(category);
	}


	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}
	
	public long getCategoryId(String categoryName) {
		Category category = categoryRepository.findByCategoryName(categoryName);
		return category.getId();
	}
	
	public Category getCategory(String categoryName) {
		Category category = categoryRepository.findByCategoryName(categoryName);
		return category;
	}


	public void deleteCategoryByName(String categoryName) {
		categoryRepository.deleteByCategoryName(categoryName);
	}


	public List<Category> getAllCategories() {
		
		List<Category> result = categoryRepository.findAll();
		return result;
	}

}
