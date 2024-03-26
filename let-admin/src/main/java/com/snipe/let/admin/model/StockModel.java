package com.snipe.let.admin.model;

import java.time.LocalDateTime;

public class StockModel {

	private String stockId;
	private String userId;
	private int vendorRoleId;
	private long categoryId;
	private long subCategoryId;
	private long categoryTypeId;
	private String quality;
	private Double totalQuantity;
	private Double availableQuantity;
	private Double availableStock;
	private int stockCount;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private boolean status;

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getVendorRoleId() {
		return vendorRoleId;
	}

	public void setVendorRoleId(int vendorRoleId) {
		this.vendorRoleId = vendorRoleId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public long getCategoryTypeId() {
		return categoryTypeId;
	}

	public void setCategoryTypeId(long categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public Double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Double getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Double availableStock) {
		this.availableStock = availableStock;
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

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

}
