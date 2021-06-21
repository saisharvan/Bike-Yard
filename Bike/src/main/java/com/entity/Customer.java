package com.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="customer")
public class Customer {


	public Customer() {}
	public Customer(String firstname, String lastname, int age, String gender, String email, String num,
			String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.num = num;
		this.address = address;
	}
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	@Id
	int id;
	@Column(name="FirstName")
	String firstname;
	@Column(name="LastName")
	String lastname;
	@Column(name="Age")
	int age;
	@Column(name="Gender")
	String gender;
	@Column(name="Email")
	String email;
	@Column(name="PhoneNumber")
	String num;
	@Column(name="Address")
	String address;
	@Column(name="Password")
	String password;
	@Column(name="book")
	int bookId;
	



	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
