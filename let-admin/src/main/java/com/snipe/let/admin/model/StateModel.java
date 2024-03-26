package com.snipe.let.admin.model;

import java.io.Serializable;

import com.snipe.let.admin.domain.CountryDomain;

public class StateModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065059773451498397L;

	private long stateId;
	private String stateName;
	private CountryDomain countryDomain;
	private boolean status;
	private String shortName;
	private long total;
	// private CountryDomain countryDomain;

	public StateModel() {

	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public CountryDomain getCountryDomain() {
		return countryDomain;
	}

	public void setCountryDomain(CountryDomain countryDomain) {
		this.countryDomain = countryDomain;
	}

	// public CountryDomain getCountryDomain() {
	// return countryDomain;
	// }
	//
	// public void setCountryDomain(CountryDomain countryDomain) {
	// this.countryDomain = countryDomain;
	// }

}