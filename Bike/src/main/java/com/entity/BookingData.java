package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookingdata")
public class BookingData {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	@Id
	int id;
	
	@Column(name="bikeId")
	int bikeId;
	
	@Column(name="customerId")
	int customerId;
	
	@Column(name="showadminId")
	int showadminId;
	
	@Column(name="paymentId")
	int paymentId;
	
	@Column(name="status")
	String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getShowadminId() {
		return showadminId;
	}

	public void setShowadminId(int showadminId) {
		this.showadminId = showadminId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingData [id=" + id + ", bikeId=" + bikeId + ", customerId=" + customerId + ", showadminId="
				+ showadminId + ", paymentId=" + paymentId + ", status=" + status + "]";
		
		
	}

	public BookingData() {
		super();
	}

	public BookingData(int bikeId, int customerId, int showadminId, int paymentId, String status) {
		super();
		this.bikeId = bikeId;
		this.customerId = customerId;
		this.showadminId = showadminId;
		this.paymentId = paymentId;
		this.status = status;
	}
	
	
}
