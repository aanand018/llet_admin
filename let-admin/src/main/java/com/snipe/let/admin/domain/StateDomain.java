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
@Table(name = "states")
public class StateDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2837436206071338244L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stateId")
	private long stateId;

	@Column(name = "stateName")
	private String stateName;

	@ManyToOne
	@JoinColumn(name = "countryId")
	private CountryDomain countryDomain;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean status;

	@Column(name = "shortName")
	private String shortName;

	public StateDomain() {

	}

	public StateDomain(String stateName, boolean status, String shortName) {
		this.stateName = shortName;
		this.status = status;
		this.shortName = shortName;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

}
