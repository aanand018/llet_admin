package com.snipe.let.admin.model;

import java.io.Serializable;

import com.snipe.let.admin.domain.StateDomain;

public class CityModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801768889220828341L;
	/**
	 * 
	 */
	private long cityId;
	private String cityName;
	private StateDomain stateDomain;
	private String shortName;
	private boolean status;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public StateDomain getStateDomain() {
		return stateDomain;
	}

	public void setStateDomain(StateDomain stateDomain) {
		this.stateDomain = stateDomain;
	}
}
