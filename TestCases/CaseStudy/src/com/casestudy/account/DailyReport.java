package com.casestudy.account;
import java.time.LocalDateTime;

public class DailyReport {
	int accNo;
	String Operation;
	LocalDateTime date;
	double amount;
	
	
	public DailyReport() {
		super();
	}
	public DailyReport(int accNo, String operation, LocalDateTime date, double amount) {
		super();
		this.accNo = accNo;
		Operation = operation;
		this.date = date;
		this.amount = amount;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getOperation() {
		return Operation;
	}
	public void setOperation(String operation) {
		Operation = operation;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void display()
	{
		System.out.println("AccNo : "+this.accNo+"\nOperation : "+this.Operation+"\nDate : "+this.date+"\nAmount : "+this.amount);
	System.out.println("\n-------------------------------------\n");
	}
	
}
