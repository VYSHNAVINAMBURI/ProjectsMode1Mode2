package com.bankapp.web.controller.beans;

public class TransferRequests {
	private long fromAccount;
	private long toAccount;
	private Double amount;

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransferRequests(long fromAccount, long toAccount, Double amount) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransferRequests [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount + "]";
	}

	public TransferRequests() {
		super();
	}

}
