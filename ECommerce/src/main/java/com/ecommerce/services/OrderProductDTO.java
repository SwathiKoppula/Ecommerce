package com.ecommerce.services;

import java.time.LocalDate;

public class OrderProductDTO {
	
//	private Long OrderId;
//	private Long id;
//	private String productName;
//	private String status;
//	private LocalDate orderedDate;
//	private LocalDate deliverDate;
	
	    private Long orderId;
	    private Long productId;
	    private String productName;
	    private String status;
	    private LocalDate orderedDate;
	    private LocalDate deliveryDate;
	
	public OrderProductDTO(Long orderId, Long productId, String productName, String status, LocalDate orderedDate,LocalDate deliveryDate) {
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.status = status;
		this.orderedDate = orderedDate;
		this.deliveryDate = deliveryDate;
	}
	
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}
	
}
