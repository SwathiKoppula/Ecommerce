package com.ecommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
  
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String title;
	    private double price;
	    private int reviews;
	    private String description;
	    
	    @Column(name="image_url")
	    private String imageUrl;
	    
	    @ManyToOne
	    @JoinColumn(name = "category_id", referencedColumnName = "id")
	    private Category category;
	    
//	    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL, orphanRemoval = true)
//	    private List<Order> orders;
//	    
//	    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//	    private List<Cart> cart;
	    
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getReviews() {
			return reviews;
		}
		public void setReviews(int reviews) {
			this.reviews = reviews;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}

}
