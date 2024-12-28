package com.ecommerce.models;


public class CartProductDto {
	
	private Long cartId;
    private Long productId;
    private String title;
    private double price;
    private int reviews;
    private String description;
    private String imageUrl;
    
	public CartProductDto(Long cartId, Long productId, String title, double price, int reviews, String description,String imageUrl) {
		this.cartId = cartId;
		this.productId = productId;
		this.title = title;
		this.price = price;
		this.reviews = reviews;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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
	
	

    
    
}
