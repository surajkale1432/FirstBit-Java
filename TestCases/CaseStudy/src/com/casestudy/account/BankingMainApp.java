package com.casestudy.account;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BankingMainApp implements AccountLifeCycle {
	int Index;
	int size = 20;
	Account[] arr;
	Scanner sc = new Scanner(System.in);

	public BankingMainApp() {
		super();
		Index = -1;
		size = 20;
		arr = new Account[size];

	}

	@Override
	public void openAccount(int choice) {
		int accNo;
		String name;
		double bal;
		int minBal;
		double rOI;
		int maxLimit, ODLimit;
		LocalDateTime currentTime;

		System.out.print("\nEnter Account No : ");
		accNo = sc.nextInt();
		System.out.print("\nEnter Name : ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.print("\nEnter Balance : ");
		bal = sc.nextDouble();
		while (bal < 10000) {
			System.out.println("\nMin Balance is too Low..required at least 10000 Rs.");
			System.out.print("\nEnter Balance : ");
			bal = sc.nextDouble();
		}
//		System.out.print("\nEnter ROI : ");
//		rOI = sc.nextDouble();
		switch (choice) {
		case 1: {
			rOI = 0.07;
			minBal = 10000;
			arr[++Index] = new SavingAccount(accNo, name, bal, minBal, rOI);
			System.out.println("\n Account Created Successfully...");
		}

			break;
		case 2: {
			currentTime = LocalDateTime.now();
			rOI = 0.08;
			arr[++Index] = new SalaryAccount(accNo, name, bal, currentTime, rOI);
			System.out.println("\n Account Created Successfully...");
		}
			break;
		case 3: {
			rOI = 0.09;
			System.out.print("\nEnter MaxLimit = ");
			maxLimit = sc.nextInt();
			System.out.print("\nEnter ODLimit = ");
			ODLimit = sc.nextInt();
			arr[++Index] = new CurrentAccount(accNo, name, bal, maxLimit, ODLimit, rOI);
			System.out.println("\n Account Created Successfully...");
		}
			break;

		case 4: {
			rOI = 0.12;
			int loanAmmount = 50000;
			arr[++Index] = new LoanAccount(accNo, name, bal, loanAmmount, rOI);
			System.out.println("\n Account Created Successfully...");
		}
			break;

		}
	}

	@Override
	public void closeAccount(int accNo1) {
		int temp = -1;
		for (int i = 0; i <= Index; i++) {
			if (arr[i].getAccNo() == accNo1) {
				temp = i;
			}
		}
		if (temp != -1) {
			for (int i = temp; i <= Index; i++) {
				arr[i] = arr[i + 1];
			}
			System.out.println("\nAccount with number " + accNo1 + " deleted Successfully...");
			Index--;
		} else {
			System.out.println("\nAccount Number Not exists . . ");
		}

	}

	public int checkUser(int accNo) {
		for(int i=0;i<=Index;i++)
		{
			if(arr[i].getAccNo()==accNo)
			{
				System.out.println("\nInside Checking");
				return i;
			}
		}
		return -1;
	}
}