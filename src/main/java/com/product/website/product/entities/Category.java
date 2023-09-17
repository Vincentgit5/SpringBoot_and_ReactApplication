package com.product.website.product.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cathegory")
public class Category {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		@Column(nullable = false, length = 30)
	private String name;
		@Column(nullable = false, length = 20)
	private String reference;
		
		@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	    private List<Product> products;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Category(Long id, String name, String reference) {
		super();
		this.id = id;
		this.name = name;
		this.reference = reference;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
