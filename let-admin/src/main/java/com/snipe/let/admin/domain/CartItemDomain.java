package com.snipe.let.admin.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cart")
public class CartItemDomain implements Serializable {

	private static final long serialVersionUID = 3565274714741656226L;

	@Id
	@Column(name = "cartItemId")
	private String cartItemId;

	@Column(name = "categoryId")
	private Long categoryId;

	@Column(name = "productId")
	private long productId;

	@Column(name = "categoryTypeId")
	private Long categoryTypeId;

	@Column(name = "quality")
	private String quality;

	@Column(name = "quantity")
	private Double quantity;

	@Column(name = "userId")
	private String userId;

	@Column(name = "createdDate")
	@CreationTimestamp
	private LocalDateTime createdDate;

	@Column(name = "modifiedDate")
	@UpdateTimestamp
	private LocalDateTime modifiedDate;

	@Column(name = "status")
	private boolean status;
	
	@Column(name ="count")
	private long count;
	
	public long getCount() {
		return count;
	} 

	public void setCount(long count) {
		this.count = count;
	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryTypeId(Long categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Long getCategoryTypeId() {
		return categoryTypeId;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
