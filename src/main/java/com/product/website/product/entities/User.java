package com.product.website.product.entities;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.Date;
import java.util.List;

@Entity
@Table(name ="user")
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		@Column(length = 255, nullable = false)
	private String firstname;
		@Column(length = 255, nullable = false)
	private String lastname;
		@Column(length = 255, nullable = false)
	private String email;
		@Column(length = 25, nullable = false)
	private String telNumber;
		@Column(length = 25, nullable = false)
	private String address;
	private Date birthDate;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public User(String firstname, String lastname, String email, String telNumber, String address, Date birthDate,
			List<Product> products) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.telNumber = telNumber;
		this.address = address;
		this.birthDate = birthDate;
		this.products = products;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", telNumber=" + telNumber + ", address=" + address + ", birthDate=" + birthDate + ", products="
				+ products + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}
