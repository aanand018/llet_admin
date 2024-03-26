package com.snipe.let.admin.model;

import java.io.Serializable;
import java.util.List;

public class CartItemModel implements Serializable {

	private static final long serialVersionUID = -7771973241806546666L;

	private String cartItemId;
	private List<ProductsModel> productsModel;
	private String userId;
	private int userRoleId;
	private String productName;
	private String productImage;
	private Double totalAmount;
	private int  total;
	private long count;
	
	

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public List<ProductsModel> getProductsModel() {
		return productsModel;
	}

	public void setProductsModel(List<ProductsModel> productsModel) {
		this.productsModel = productsModel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
