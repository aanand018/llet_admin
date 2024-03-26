package com.snipe.let.admin.domain;







import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "catalogue")
public class CatalogueDomain implements Serializable{

	private static final long serialVersionUID = 3914296347354483656L;

	@Id
	private String catalogueId;

	private String catalogueName;

	private long categoriesId;

	private long stateId;

	private long cityId;

	private LocalDate fromDate;

	private LocalDate toDate;

	private String catalogueType;

	private long productId;

	private double unitPrice;

	private double discountPerctg;

	private boolean catalogueStatus;

	private boolean productStatus;// dt about bit

	private String storeType;


	public long getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(long categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getCatalogueId() {
		return catalogueId;
	}

	public void setCatalogueId(String catalogueId) {
		this.catalogueId = catalogueId;
	}

	public String getCatalogueName() {
		return catalogueName;
	}

	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getCatalogueType() {
		return catalogueType;
	}

	public void setCatalogueType(String catalogueType) {
		this.catalogueType = catalogueType;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscountPerctg() {
		return discountPerctg;
	}

	public void setDiscountPerctg(double discountPerctg) {
		this.discountPerctg = discountPerctg;
	}

	public boolean getCatalogueStatus() {
		return catalogueStatus;
	}

	public void setCatalogueStatus(boolean catalogueStatus) {
		this.catalogueStatus = catalogueStatus;
	}

	public boolean getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	
	

	
	@Override
	public String toString() {
		return "CatalogueDomain [catalogueId=" + catalogueId + ", catalogueName=" + catalogueName + ", categoriesId="
				+ categoriesId + ", stateId=" + stateId + ", cityId=" + cityId + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", catalogueType=" + catalogueType + ", productId=" + productId + ", unitPrice=" + unitPrice
				+ ", discountPerctg=" + discountPerctg + ", catalogueStatus=" + catalogueStatus + ", productStatus="
				+ productStatus + ", storeType=" + storeType + "]";
	}

	public CatalogueDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatalogueDomain(String catalogueId, String catalogueName, long categoriesId, long stateId, long cityId,
			LocalDate fromDate, LocalDate toDate, String catalogueType, long productId, double unitPrice,
			double discountPerctg, boolean catalogueStatus, boolean productStatus, String storeType) {
		super();
		this.catalogueId = catalogueId;
		this.catalogueName = catalogueName;
		this.categoriesId = categoriesId;
		this.stateId = stateId;
		this.cityId = cityId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.catalogueType = catalogueType;
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.discountPerctg = discountPerctg;
		this.catalogueStatus = catalogueStatus;
		this.productStatus = productStatus;
		this.storeType = storeType;
	}

	




}

































/*
import java.time.LocalDate;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Catalogue")
public class CatalogueDomain {
	
	@Id
	private String catalogueId;
	
	private String catalogueName;
	
	@ManyToOne
	private StateDomain state;
	
	@ManyToOne
	private CityDomain city;
	
	
	private LocalDate fromDate;
	
	private LocalDate toDate;
	
	private String catalogueType;
	
	private String productId;
	
	private double unitPrice;
	
	
	private double discount;
	
	private boolean catalogueStatus;
	
	private boolean productStatus;
	
	private String storeType;

	public String getCatalogueId() {
		return catalogueId;
	}

	public void setCatalogueId(String catalogueId) {
		this.catalogueId = catalogueId;
	}

	public String getCatalogueName() {
		return catalogueName;
	}

	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	public StateDomain getState() {
		return state;
	}

	public void setState(StateDomain state) {
		this.state = state;
	}

	public CityDomain getCity() {
		return city;
	}

	public void setCity(CityDomain city) {
		this.city = city;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getCatalogueType() {
		return catalogueType;
	}

	public void setCatalogueType(String catalogueType) {
		this.catalogueType = catalogueType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
	
	public boolean getCatalogueStatus() {
		return catalogueStatus;
	}

	public void setCatalogueStatus(boolean catalogueStatus) {
		this.catalogueStatus = catalogueStatus;
	}
	

	public boolean getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public CatalogueDomain(String catalogueId, String catalogueName, StateDomain state, CityDomain city,
			LocalDate fromDate, LocalDate toDate, String catalogueType, String productId, double unitPrice,
			double discount, boolean catalogueStatus, boolean productStatus, String storeType) {
		super();
		this.catalogueId = catalogueId;
		this.catalogueName = catalogueName;
		this.state = state;
		this.city = city;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.catalogueType = catalogueType;
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.catalogueStatus = catalogueStatus;
		this.productStatus = productStatus;
		this.storeType = storeType;
	}

	public CatalogueDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	


	 
	
	
	
	
	
 
	
}

*/
