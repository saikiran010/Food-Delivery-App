package com.example.fooddeliveryproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private LocalDateTime dateTime;
	private double totalCost;
	private int totalItem;
	 
	@OneToOne(mappedBy="bill",cascade = CascadeType.ALL)
	private OrderDetails order;

	public Bill() {
		super();
	}

	public Bill(int billId, LocalDateTime dateTime, double totalCost, int totalItem, OrderDetails order) {
		super();
		this.billId = billId;
		this.dateTime = dateTime;
		this.totalCost = totalCost;
		this.totalItem = totalItem;
		this.order = order;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", dateTime=" + dateTime + ", totalCost=" + totalCost + ", totalItem="
				+ totalItem + ", order=" + order + "]";
	}

}
