package com.ecommerce.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name = "user_name", referencedColumnName = "user_name")
	private User user;
    
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
    
	private String status;
	
	@Column(name="ordered_date")
	private LocalDate orderedDate;
	
	@Column(name="delivery_date")
	private LocalDate deliveryDate;
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = "Ordered";
	}
	public LocalDate getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}
	public LocalDate getDeliverDate() {
		return deliveryDate;
	}
	public void setDeliverDate(LocalDate deliverDate) {
		this.deliveryDate = deliverDate;
	}
	

}
