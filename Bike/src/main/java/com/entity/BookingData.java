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
	
}
