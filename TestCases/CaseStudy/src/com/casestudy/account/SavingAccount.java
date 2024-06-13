package com.casestudy.account;

public class SavingAccount extends Account {
	int minBalance;
	double rateOfInterest;

	public SavingAccount() {
		super();
	}

	public SavingAccount(int accNo, String name, double bal, int minBalance, double rateOfInterest) {
		super(accNo, name, bal);
		this.minBalance = minBalance;
		this.rateOfInterest = rateOfInterest;
	}

	public int getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(int minBalance) {
		this.minBalance = minBalance;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		if (amount > 0) {
			if ((this.balance - amount) >= 10000) {
				this.balance = this.balance - amount;
				return true;

			} else {
				System.out.println("\nInsufficient funds...");
				return false;
			}
		} else {
			System.out.println("\nInvalid amount");
			return false;
		}

	}

	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		this.balance = this.balance + amount;
		System.out.println("\nAmount " + amount + " Credited successfully ....");
		return true;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.display();
		System.out.println("\nRate of Interest : " + this.rateOfInterest);
		System.out.println("\nMin bal : " + this.minBalance);
	}

	@Override
	public void calInterest() {
		double interest = this.rateOfInterest * this.balance;
		System.out.println(
				"\nYour Estimated Interest After 1 Year Is = " + interest + " with ROI = " + this.rateOfInterest);

	}

}
