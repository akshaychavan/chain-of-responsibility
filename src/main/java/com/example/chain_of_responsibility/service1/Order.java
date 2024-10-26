package com.example.chain_of_responsibility.service1;

public class Order {

	public Order(String orderId, double amount, String tranTypeCodes) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.tranTypeCodes = tranTypeCodes;
	}
	
	public Order() {}

	private String orderId;
	private String status;
	private double amount;
	private double amountPendingSettle;
	private double amountSettle;
	private String tranTypeCodes;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmountPendingSettle() {
		return amountPendingSettle;
	}

	public void setAmountPendingSettle(double amountPendingSettle) {
		this.amountPendingSettle = amountPendingSettle;
	}

	public double getAmountSettle() {
		return amountSettle;
	}

	public void setAmountSettle(double amountSettle) {
		this.amountSettle = amountSettle;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", amount=" + amount + ", amountPendingSettle="
				+ amountPendingSettle + ", amountSettle=" + amountSettle + "]";
	}

	public String getTranTypeCodes() {
		return tranTypeCodes;
	}

}
