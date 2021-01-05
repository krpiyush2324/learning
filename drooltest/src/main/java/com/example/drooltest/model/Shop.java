package com.example.drooltest.model;

import java.util.List;

public class Shop {

	private String shopName;
	List<Product> product;

	public Shop(String shopName, List<Product> product) {
		super();
		this.shopName = shopName;
		this.product = product;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
