package com.snipe.let.admin.model;

import java.io.Serializable;

public class CountryModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065059773451498397L;

	private long countryId;
	private String shortname;
	private String countryName;
	private String CountryCode;
	// private LocalDateTime creationDate;
	// private LocalDateTime modificationDate;
	private boolean status;

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	//
	// public LocalDateTime getCreationDate() {
	// return creationDate;
	// }
	//
	// public void setCreationDate(LocalDateTime creationDate) {
	// this.creationDate = creationDate;
	// }
	//
	// public LocalDateTime getModificationDate() {
	// return modificationDate;
	// }
	//
	// public void setModificationDate(LocalDateTime modificationDate) {
	// this.modificationDate = modificationDate;
	// }

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
