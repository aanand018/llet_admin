package com.snipe.let.admin.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.snipe.let.admin.domain.CartItemDomain;
import com.snipe.let.admin.domain.CategoriesDomain;
import com.snipe.let.admin.domain.CategoriesTypeDomain;
import com.snipe.let.admin.domain.SubCategoriesImageDomain;

@JsonInclude(Include.NON_DEFAULT)

public class SubCategoriesModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3854672081801034320L;

	private long subCategoriesId;
	private String subCategoriesName;
	private CategoriesDomain categoriesDomain;
	private CategoriesTypeDomain categoriesTypeDomain;
	private Double price;
	private String description;
	private String Quantity;
	private int serve;
	private String detailDescription;
	private Double availableStock;
	private SubCategoriesImageDomain subCategoriesImage;
	private CartItemDomain cartItemDomain;
	private StockModel stockModel;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getServe() {
		return serve;
	}

	public void setServe(int serve) {
		this.serve = serve;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getSubCategoriesId() {
		return subCategoriesId;
	}

	public void setSubCategoriesId(long subCategoriesId) {
		this.subCategoriesId = subCategoriesId;
	}

	public String getSubCategoriesName() {
		return subCategoriesName;
	}

	public void setSubCategoriesName(String subCategoriesName) {
		this.subCategoriesName = subCategoriesName;
	}

	public CategoriesDomain getCategoriesDomain() {
		return categoriesDomain;
	}

	public void setCategoriesDomain(CategoriesDomain categoriesDomain) {
		this.categoriesDomain = categoriesDomain;
	}

	public CategoriesTypeDomain getCategoriesTypeDomain() {
		return categoriesTypeDomain;
	}

	public void setCategoriesTypeDomain(CategoriesTypeDomain categoriesTypeDomain) {
		this.categoriesTypeDomain = categoriesTypeDomain;
	}

	public SubCategoriesImageDomain getSubCategoriesImage() {
		return subCategoriesImage;
	}

	public void setSubCategoriesImage(SubCategoriesImageDomain subCategoriesImage) {
		this.subCategoriesImage = subCategoriesImage;
	}

	public CartItemDomain getCartItemDomain() {
		return cartItemDomain;
	}

	public void setCartItemDomain(CartItemDomain cartItemDomain) {
		this.cartItemDomain = cartItemDomain;
	}

	public Double getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Double availableStock) {
		this.availableStock = availableStock;
	}

	public StockModel getStockModel() {
		return stockModel;
	}

	public void setStockModel(StockModel stockModel) {
		this.stockModel = stockModel;
	}

}
