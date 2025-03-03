package com.ducat.modal;

public class CreditCard {
	
	private String name;
	private int number;
	private String month;
	private int year;
	private int cvv;
	public CreditCard() {
		super();
	}
	public CreditCard(String name, int number, String month, int year, int cvv) {
		super();
		this.name = name;
		this.number = number;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CreditCard [name=" + name + ", number=" + number + ", month=" + month + ", year=" + year + ", cvv="
				+ cvv + "]";
	}
	

}
