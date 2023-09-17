package com.product.website.product.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		@Column(length = 25, nullable = false)
	private String nameProduct;
		@Column(nullable = false)
	private String priceProdduct;
		@Column(nullable = false)
	private Date creationDate;
		@Column(nullable = false)
	private Date expirationDate;
		@Column(nullable = false)
	private String description;
		@Column(nullable = false)
	private String image;
		@Column(nullable = false)
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getPriceProdduct() {
		return priceProdduct;
	}

	public void setPriceProdduct(String priceProdduct) {
		this.priceProdduct = priceProdduct;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(String nameProduct, String priceProdduct, Date creationDate, Date expirationDate, String description,
			String image, Integer quantity, User user, Category category) {
		super();
		this.nameProduct = nameProduct;
		this.priceProdduct = priceProdduct;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
		this.user = user;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nameProduct=" + nameProduct + ", priceProdduct=" + priceProdduct
				+ ", creationDate=" + creationDate + ", expirationDate=" + expirationDate + ", description="
				+ description + ", image=" + image + ", quantity=" + quantity + ", user=" + user + ", category="
				+ category + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
