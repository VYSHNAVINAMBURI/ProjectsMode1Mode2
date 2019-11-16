package com.bankapp.web.controller.beans;

public class DepositeAndWithdrawRequests {
	private long accountNumber;
	private Double amount;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public DepositeAndWithdrawRequests(long accountNumber, Double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DepositeAndWithdrawRequests [accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}

	public DepositeAndWithdrawRequests() {
		super();
	}

}
