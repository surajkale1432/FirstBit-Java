package com.casestudy.account;

public class LoanAccount extends Account{
	
	double rateOfInterest;
	int LoanAmmount;
	public LoanAccount() {
		super();
	}
	public LoanAccount(int accNo,String name, double bal, int loanAmmount,double rateOfInterest) {
		super(accNo,name,bal);
		this.rateOfInterest = rateOfInterest;
		LoanAmmount = loanAmmount;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public int getLoanAmmount() {
		return LoanAmmount;
	}
	public void setLoanAmmount(int loanAmmount) {
		LoanAmmount = loanAmmount;
	}
	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		return true;
		
	}
	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("\nYou Current Balance = "+this.balance);
		
	}
	@Override
	public void calInterest() {
		// TODO Auto-generated method stub
		double interest = this.rateOfInterest * this.balance;
		System.out.println(
				"\nYour Estimated Interest After 1 Year Is = " + interest + " with ROI = " + this.rateOfInterest);
		
	}
	public void display() {
		// TODO Auto-generated method stub
		super.display();
		System.out.println("\nRate of Interest : "+this.rateOfInterest);
		System.out.println("\nLoan Amount : "+this.LoanAmmount);
	}
	

}
