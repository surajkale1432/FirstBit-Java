package com.casestudy2.java;
//import java.util.*;
public class Room {

//	int index=-1;
	String roomType;
	Device[] device = new Device[10];

//	List<switchable> device = new ArrayList();
	public Room() {

	}
	public Room(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void onDevice(String dName) {
		for (int i = 0; i < 10; i++) {
			if (device[i].deviceName.equals(dName)) {
				if(device[i].status==false)
				device[i].onDevice();
				else
					System.out.println("\nDevice is already On...");
			}
		}
	}
	public void addDevice(String device2,int dIndex) {
		// TODO Auto-generated method stub
		device[dIndex]=new Device(device2);
//		System.out.println("\nDevice Added successfully");
	}
	public void checkStatus(String device2,int dIndex) {
		// TODO Auto-generated method stub
		for(int i=0;i<=dIndex;i++)
		{
			if(device[i].deviceName.equals(device2))
			{
				System.out.println("Device Name = "+this.device[i].deviceName+"    Status = "+this.device[i].status);
			}
		}
		
	}
}
