package com.casestudy.account;

public abstract class Account implements CounterActivities {
	int accNo;
	String custName;
	double balance;

	public Account() {
		super();
	}

	public Account(int accNo, String custName, double balance) {
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.balance = balance;
	}

	public int getAccNo() {
		return this.accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		this.balance += amount;
		System.out.println("\nAmount " + amount + " deposited successfully..\ncurrent Balance = " + this.balance);
		return true;

	}

	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("\nYour Current Balance = " + this.balance);

	}

	public void display() {
		System.out.println("\nAcc No : " + this.accNo);
		System.out.println("\nName : " + this.custName);
		System.out.println("\nBalance : " + this.balance);

	}

}
