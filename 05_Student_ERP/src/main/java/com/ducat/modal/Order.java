package com.ducat.modal;

import java.time.LocalDate;

public class Order extends Product{
	private int o_id;
	private int p_id;
	private int u_id;
	private int o_quantity;
	private LocalDate o_date;

	

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getO_quantity() {
		return o_quantity;
	}

	public void setO_quantity(int o_quantity) {
		this.o_quantity = o_quantity;
	}

	public LocalDate getO_date() {
		return o_date;
	}

	public void setO_date(LocalDate o_date) {
		this.o_date = o_date;
	}

	
	public Order() {
	}
	
	public Order(int o_id, int p_id, int u_id, int o_quantity, LocalDate o_date) {
		this.o_id = o_id;
		this.p_id = p_id;
		this.u_id = u_id;
		this.o_quantity = o_quantity;
		this.o_date = o_date;
	}
	

	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ",p_id=" + p_id + ", u_id=" + u_id + ", o_quantity=" + o_quantity + ", o_date="
				+ o_date + "]";
	}
}
