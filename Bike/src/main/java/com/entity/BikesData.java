package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bike")
public class BikesData
{
	
	
	///////////////////////////
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	@Id
	int id;
	@Column(name="bikeName")
	String bikeName;
	@Column(name="bikeCost")
	int bikeCost;
	@Column(name="bikeColor")
	String bikeColor;
	@Column(name = "bikeDescription")
	String bikeDescription;
	@Column(name = "availability")
	String availability;
	@Column(name = "sraId")
	int sraId;
	
	public int getSraId() {
		return sraId;
	}


	public void setSraId(int sraId) {
		this.sraId = sraId;
	}


	public String getBikeDescription() {
		return bikeDescription;
	}


	public void setBikeDescription(String bikeDescription) {
		this.bikeDescription = bikeDescription;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public BikesData() {}
	
	
	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public int getBikeCost() {
		return bikeCost;
	}

	public void setBikeCost(int bikeCost) {
		this.bikeCost = bikeCost;
	}

	public String getBikeColor() {
		return bikeColor;
	}

	public void setBikeColor(String bikeColor) {
		this.bikeColor = bikeColor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public BikesData(int id, String bikeName, int bikeCost, String bikeColor, String bikeDescription,
			String availability) {
		super();
		this.id = id;
		this.bikeName = bikeName;
		this.bikeCost = bikeCost;
		this.bikeColor = bikeColor;
		this.bikeDescription = bikeDescription;
		this.availability = availability;
	}


	@Override
	public String toString() {
		return "BikesData [id=" + id + ", bikeName=" + bikeName + ", bikeCost=" + bikeCost + ", bikeColor=" + bikeColor
				+ ", bikeDescription=" + bikeDescription + ", availability=" + availability + ", sraId=" + sraId + "]";
	}


	
	
	
	
}
