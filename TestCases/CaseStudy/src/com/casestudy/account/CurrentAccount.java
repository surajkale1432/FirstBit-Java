package com.casestudy.account;

public class CurrentAccount extends Account{

	int maxLimit;
	int overDraftLimit;
	double rateOfInterest;

//	int currentBalance;
	public CurrentAccount() {
		super();
	}

	public CurrentAccount(int accNo,String name,double bal,int maxLimit, int overDraftLimit, double rateOfInterest) {
		super(accNo,name,bal);
		this.maxLimit = maxLimit;
		this.overDraftLimit = overDraftLimit;
		this.rateOfInterest = rateOfInterest;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}

	public int getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(int overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
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
		if((this.balance+this.overDraftLimit)>amount)
		{
			this.balance=this.balance-amount;
			return true;
		}
		else
		{
			return false;
		}
		
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
		System.out.println("\nMax Limit : "+this.maxLimit);
		System.out.println("\nOverDraft Limit : "+this.overDraftLimit);
		System.out.println("\nRate Of interest : "+this.rateOfInterest);
	}

}
