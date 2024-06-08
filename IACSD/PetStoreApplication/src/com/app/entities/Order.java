package com.app.entities;

import java.util.Objects;

import com.app.enums.Status;

public class Order {
	// orderId, petId, quantity, status
	private int orderId;
	private int petId;
	private int quantity;
	private Status status;
	private static int c = 100;
	
	public Order(int petId, int quantity) {
		super();
		this.orderId = ++c;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.PLACED;
	}

	public Order(int orderId1) {
		super();
		this.orderId=orderId1;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return orderId == other.orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}

}
