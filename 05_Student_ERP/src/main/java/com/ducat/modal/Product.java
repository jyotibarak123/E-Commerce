package com.ducat.modal;

public class Product {

	private int id;
	private String title;
	private String description;
	private double price;
	private String image;
	public Product() {
	}
	public Product(int id, String title, String description, double price, String image) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price + ", image="
				+ image + "]";
	}
	
	
}
