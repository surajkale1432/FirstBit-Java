package com.casestudy.account;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

//import java.lang.*;
public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice, nxCh, accNo, amount;
		String pass = "Admin";
		String passValidate;
		try (Scanner sc = new Scanner(System.in)) {
			BankingMainApp bma = new BankingMainApp();
			int dlindex=-1;
			DailyReport dl[]=new DailyReport[100];
			do {
				System.out.println("\nWelcome to Banking\n\n1. LifeCycle Operation 2. Banking Operations");
				choice = sc.nextInt();
				if (choice == 1) {
					System.out.print("\nEnter Admin Password = ");
					sc.nextLine();
					passValidate = sc.nextLine();
					if (pass.compareTo(passValidate) == 0) {
						System.out.println("\nLogged In successfully...");
						
						do
						{
							System.out.println("\n1.Open Account\n2. Close Account\n3.DailyReport\n9. Return To Main Menu\nChoice = ");
							choice = sc.nextInt();
							if (choice == 1) {
								System.out.println("\n1. Saving 2. Salary\n3. Current\n4. Loan");
								nxCh = sc.nextInt();
								bma.openAccount(nxCh);
							} else if (choice == 2) {
								System.out.println("\nEnter Account No : ");
								accNo = sc.nextInt();
								bma.closeAccount(accNo);
							}
							else if(choice==3)
							{
//								System.out.println(cl);
								LocalDateTime dateNow=LocalDateTime.now();
								
								System.out.println("\nYour Todays Transactions \n");
								for(int i=0;i<=dlindex;i++)
								{
									if(dateNow.getDayOfMonth()==dl[i].getDate().getDayOfMonth() && dateNow.getMonth()==dl[i].getDate().getMonth() && dateNow.getYear()==dl[i].getDate().getYear())
									{
										dl[i].display();
									}
								}
							}
							else if(choice==9)
							{
								break;
							}
						}while(choice<3 && choice>=0);
						
					} else {
						System.out.println("\nWrong password Try Again ...");
					}
				} else if (choice == 2) {
					Account acc[] = bma.arr;
//				acc[0].display();
					System.out.println("\nEnter Your Account Number = ");
					accNo = sc.nextInt();
					int tempIndex = bma.checkUser(accNo);
					if (tempIndex != -1) {
						do {
							System.out.println("\n1. Withdraw\n2. Deposit \n3. CheckBalance\n4. Close Account\n0. Return To Main Menu \nChoice = ");
							nxCh = sc.nextInt();
							switch (nxCh) {
							case 1: {
								System.out.println("\nEnter Amount To Withdraw = ");
								amount = sc.nextInt();
								if(acc[tempIndex].withdraw(amount))
								{
									dl[++dlindex]=new DailyReport(accNo,"WITHDRAW",LocalDateTime.now(),amount);
								}
								

							}
							break;
							case 2:
							{
								System.out.println("\nEnter Amount to Deposit = ");
								amount=sc.nextInt();
								acc[tempIndex].deposit(amount);
								dl[++dlindex]=new DailyReport(accNo,"DEPOSIT",LocalDateTime.now(),amount);

							}
							break;
							case 3:
							{
								acc[tempIndex].checkBalance();
							}
							break;
							case 4:
							{
								bma.closeAccount(accNo);
							}
							default:
								System.out.println("\nSomething went wrong please try again ...");
							}
						} while (nxCh != 0);
					} else {
						System.out.println("\nAccount Not found with AccNo = " + accNo + "\nPlease Try again ...");

					}
				}
			} while (choice != 0);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception = "+e);
		}

	}

}
