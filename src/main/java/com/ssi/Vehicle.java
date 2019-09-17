package com.ssi;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Vehicle {
	
	@Id
	private int regno;
	private String brand;
	private int price;
	
	
	
	@Override
	public String toString() {
		return "Vehicle [regno=" + regno + ", brand=" + brand + ", price=" + price + "]";
	}

	public Vehicle(int regno) {
		super();
		this.regno = regno;
	}

	public Vehicle() {
		super();
	}

	

	public Vehicle(int regno, String brand, int price) {
		super();
		this.regno = regno;
		this.brand = brand;
		this.price = price;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
