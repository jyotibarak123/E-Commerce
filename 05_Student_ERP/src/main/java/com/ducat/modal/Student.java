package com.ducat.modal;

import java.time.LocalDate;

public class Student {
	private int id;
	private String name;
	private Long mobileNo;
	private char gender;
	private boolean isMember;
	private double fee;
	private LocalDate joinedAt;
	private String email;
	private String password;
	
	public Student() {
		
	}


	public Student(int id, String name, Long mobileNo, char gender, boolean isMember, double fee, LocalDate joinedAt,
			String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.isMember = isMember;
		this.fee = fee;
		this.joinedAt = joinedAt;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public LocalDate getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(LocalDate joinedAt) {
		this.joinedAt = joinedAt;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", gender=" + gender + ", isMember="
				+ isMember + ", fee=" + fee + ", joinedAt=" + joinedAt + ", email=" + email + ", password=" + password
				+ "]";
	}
	

}
