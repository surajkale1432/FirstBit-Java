package com.casestudy.account;

public interface CounterActivities {

	public boolean deposit(double amount);

	public boolean withdraw(double amount);

	public void checkBalance();

	public void calInterest();

}
