package com.codefury.backend.domain;

import java.util.Objects;

public class Products {
	private int id;
	private String name;
	private double price;
	private String category;

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(int id, String name, double price, String category) {
		// super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId( int id) {
		this.id = id;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}

}
