package com.casestudy2.java;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		int ch, rIndex = -1, dIndex = -1;
		House h1 = new House();
		System.out.println("\\nWelcome to DeviceManagement");
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.print("\n\n1.Check Status\n2. OnDevice / OffDevice\n3.Display All Devices"
						+ "\n4. Add Room\n5. Add Device\nChoice = ");

				ch = sc.nextInt();
//			
//				h1.addRoom("Kitchen",++rIndex);
//				h1.addRoom("BedRoom",++rIndex);
				switch (ch) {
				case 1: {
					if(rIndex==-1)
					{
						System.out.println("\nNo room available");
						continue;
					}
					System.out.println("\nSelect Your Room");
					for (int i = 0; i <= rIndex; i++) {
						System.out.println(i + 1 + ". " + h1.room[i].getRoomType());
					}
					System.out.print("\nChoice = ");
					int choice;
					choice = sc.nextInt();
//					System.out.println("\nDevices = ");
					System.out.print("\n\nSelect Your Device");
					for (int i = 0; i <= dIndex; i++) {
						try {
							System.out.println(i + 1 + ". " + h1.room[choice - 1].device[i].getDeviceName());
						} catch (NullPointerException e) {
							System.out.println("\nNo Device Found");
						}
					}
					System.out.print("\nChoice = ");
					int devChoice;
					devChoice = sc.nextInt();
					System.out.print("\nDevice Name\t\t\tStatus");
					System.out.print("\n" + h1.room[choice - 1].device[devChoice - 1].getDeviceName() + "\t\t\t"
							+ h1.room[choice - 1].device[devChoice - 1].status);
				}
					break;
				case 2: {
					if(rIndex==-1)
					{
						System.out.println("\nNo Room created...");
//						return;
						continue;
					}
					System.out.println("\nSelect Your Room");
					for (int i = 0; i <= rIndex; i++) {
						System.out.println(i + 1 + ". " + h1.room[i].getRoomType());
					}
					System.out.print("\nChoice = ");
					int choice;
					choice = sc.nextInt();
					System.out.print("\n\nSelect Your Device");
					if(dIndex==-1)
					{
						System.out.println("\nNo device Found...");
						continue;
					}
					for (int i = 0; i <= dIndex; i++) {
						try {
							System.out.println(i + 1 + ". " + h1.room[choice - 1].device[i].getDeviceName());
						} catch (NullPointerException e) {
							System.out.println("\nNo Device Found");
						}
					}
					System.out.print("\nChoice = ");
					int devChoice;
					devChoice = sc.nextInt();
					System.out.print("\n1. Turn On Device\n2. Turn Off Device\nChoice = ");
					int devStatus;
					devStatus=sc.nextInt();
					
					if(devStatus==1)
					{
						if(h1.room[choice-1].device[devChoice-1].status==true)
						{
							System.out.println("\nDevice is already On");
						}
						else
						{
							h1.room[choice-1].device[devChoice-1].status=true;
						}
					}
					else if(devStatus==2)
					{
						if(h1.room[choice-1].device[devChoice-1].status==false)
						{
							System.out.println("\nDevice is already Off");
						}
						else
						{
							h1.room[choice-1].device[devChoice-1].status=false;
						}
					}

				}
				break;
				case 3:{
					
				}
				break;
				case 4:{
					String rName;
					sc.nextLine();
					System.out.print("\nEnter Room Name = ");
					rName=sc.nextLine();
					h1.addRoom(rName,++rIndex);
					
				}
				break;
				case 5:{
					if(rIndex==-1)
					{
						System.out.println("\nNo Room Created first Create Room");
						continue;
					}
				
					String dName;
					sc.nextLine();
					System.out.print("\nEnter Device Name = ");
					dName=sc.nextLine();
					System.out.println("\nSelect Your Room");
					for (int i = 0; i <= rIndex; i++) {
						System.out.println(i + 1 + ". " + h1.room[i].getRoomType());
					}
					System.out.print("\nChoice = ");
					int choice;
					choice = sc.nextInt();
					if(h1.addDevice(choice-1, dName, dIndex))
					{
						dIndex++;
						System.out.println("\nDevice Added");
					}
					else
					{
						System.out.println("\nSomething went wrong");
					}
				}
				break;
				}
			} while (ch >= 0);
		}
	}

}
