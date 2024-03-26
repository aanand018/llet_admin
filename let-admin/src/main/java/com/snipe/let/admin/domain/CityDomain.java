package com.snipe.let.admin.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class CityDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4324999829375534666L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cityId")
	private long cityId;

	@Column(name = "cityName")
	private String cityName;

	
	
	@Column(name = "shortName")
	private String shortName;
	
	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "stateId")
	private StateDomain stateDomain;
	
	
	public CityDomain() {
		
	}

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

	public StateDomain getStateDomain() {
		return stateDomain;
	}

	public void setStateDomain(StateDomain stateDomain) {
		this.stateDomain = stateDomain;
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

	
}
