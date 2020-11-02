package com.ibm.msreskill.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class ProductInfo {
	
	@Id
	private int productId;
	private ProductCategory category;
	private String name;
	private double price;
	
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductInfo(int productId, ProductCategory category, String name, double price) {
		super();
		this.productId = productId;
		this.category = category;
		this.name = name;
		this.price = price;
	}


	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
