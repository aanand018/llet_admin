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
	@Table(name="area")
	public class AreaDomain implements Serializable{
		
		
		
		private static final long serialVersionUID = -4324999829375534666L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "areaId")
		private int areaId;

		@Column(name = "areaName")
		private String areaName;
		
		@Column(name="areaPincode")
		private  int pinCode;
		
		@Column(name = "longitude")
	    private double longittude;

	    @Column(name = "latitude")
	    private double lattitude;
	    
	    
	//	
	//  @ManyToOne
//		@JoinColumn(name = "cityId")
//		private CityDomain cityDomain;


		public int getAreaId() {
			return areaId;
		}

		public void setAreaId(int areaId) {
			this.areaId = areaId;
		}

		public String getAreaName() {
			return areaName;
		}

		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}

		public int getPinCode() {
			return pinCode;
		}

		public void setPinCode(int pinCode) {
			this.pinCode = pinCode;
		}

		public double getLongittude() {
			return longittude;
		}

		public void setLongittude(double longittude) {
			this.longittude = longittude;
		}

		public double getLattitude() {
			return lattitude;
		}

		public void setLattitude(double lattitude) {
			this.lattitude = lattitude;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	}
	    




		



		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
