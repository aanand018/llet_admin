package com.snipe.let.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties("let")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LETProperties {
	
	private String adminUrl;
	private String authUrl;
	private String retailerUrl;
	private String tieupseUrl;
	private String customerUrl;
	private String accessTokenKey;
	private String headerApiKey;
	private String imagepath;
	private String warehouseUrl;
	
	
	
	public String getAccessTokenKey() {
		return accessTokenKey;
	}
	public void setAccessTokenKey(String accessTokenKey) {
		this.accessTokenKey = accessTokenKey;
	}
	public String getAdminUrl() {
		return adminUrl;
	}
	public void setAdminUrl(String adminUrl) {
		this.adminUrl = adminUrl;
	}
	public String getAuthUrl() {
		return authUrl;
	}
	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}
	public String getRetailerUrl() {
		return retailerUrl;
	}
	public void setRetailerUrl(String retailerUrl) {
		this.retailerUrl = retailerUrl;
	}
	public String getTieupseUrl() {
		return tieupseUrl;
	}
	public void setTieupseUrl(String tieupseUrl) {
		this.tieupseUrl = tieupseUrl;
	}
	public String getCustomerUrl() {
		return customerUrl;
	}
	public void setCustomerUrl(String customerUrl) {
		this.customerUrl = customerUrl;
	}
	public String getHeaderApiKey() {
		return headerApiKey;
	}
	public void setHeaderApiKey(String headerApiKey) {
		this.headerApiKey = headerApiKey;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	public String getWarehouse() {
		return warehouseUrl;
	}
	public void setWarehouse(String warehouseUrl) {
		this.warehouseUrl = warehouseUrl;
	}

}
