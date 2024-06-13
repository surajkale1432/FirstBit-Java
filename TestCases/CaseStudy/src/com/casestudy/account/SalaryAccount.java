package com.casestudy.account;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class SalaryAccount extends Account {
	LocalDateTime date;
	double rateOfInterest;

	public SalaryAccount() {
		super();
	}

	public SalaryAccount(int accNo, String name, double bal, LocalDateTime date, double rateOfInterest) {
		super(accNo, name, bal);
		this.date = date;
		this.rateOfInterest = rateOfInterest;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	@Override
	public boolean deposit(double amount) {
		this.balance = this.balance + amount;
		if (!isFreeze(date)) {
			this.date = LocalDateTime.now();
		}
		return true;
	}

	@Override
	public boolean withdraw(double amount) {
		if (isFreeze(date)) {
			System.out.println("\nAccount is freezed.");
			return false;
		} else {
			if (this.balance - amount > 10000) {
				this.balance = this.balance - amount;
				System.out.println("\nAmount " + amount + " withdraw Successfully");
				date = LocalDateTime.now();
				return true;
			} else {
				System.out.println("\nBalance is too Low");
				return false;
			}

		}
	}

	private boolean isFreeze(LocalDateTime date) {
		// TODO Auto-generated method stub
		LocalDateTime currentTime = LocalDateTime.now();
		float diff = (float) this.date.until(currentTime, ChronoUnit.MINUTES);
		System.out.println("Differenec : " + diff);

		if (diff > 2) {
			return true;
		} else {
			return false;
		}
	}
//	@Override

	@Override
	public void calInterest() {
		System.out.println("\nYour interest = " + this.balance * this.rateOfInterest / 100);

	}

}
