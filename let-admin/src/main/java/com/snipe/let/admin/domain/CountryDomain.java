package com.snipe.let.admin.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryDomain implements Serializable {
	
	private static final long serialVersionUID = 3129621435637234018L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "countryId")
	private long countryId;

	@Column(name = "shortName")
	private String shortname;

	@Column(name = "countryName")
	private String countryName;

	@Column(name = "countryCode")
	private String CountryCode;

	// @Column(name = "creationDate")
	// @CreationTimestamp
	// private LocalDateTime creationDate;
	//
	// @Column(name = "modificationDate")
	// @UpdateTimestamp
	// private LocalDateTime modificationDate;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean status;

	// // @OneToMany(mappedBy = "countryDomain", cascade = CascadeType.ALL, fetch =
	// // FetchType.EAGER)
	// // private List<StateDomain> stateDomain;
	// // private Set<StateDomain> StateDomain;
	//

	public CountryDomain() {

	}

	public CountryDomain(String shortname, String countryName, String CountryCode) {
		this.shortname = shortname;
		this.countryName = countryName;
		this.CountryCode = CountryCode;

	}

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

	// public List<StateDomain> getStateDomain() {
	// return stateDomain;
	// }
	//
	// public void setStateDomain(List<StateDomain> stateDomain) {
	// this.stateDomain = stateDomain;
	// }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
