package com.casestudy2.java;

public class House {

	int index = -1;
	Room[] room = new Room[10];

	public void addRoom(String rt, int rIndex) {
		room[rIndex] = new Room(rt);
	}

	public void checkStatus(String rt, String device, int dIndex) {
		int roomIndex = isRoomExist(rt);
		if (roomIndex != -1) {
			room[roomIndex].checkStatus(device, dIndex);
		}
	}

	public boolean addDevice(int rIndex, String device, int dIndex) {
//		int roomIndex=isRoomExist(rt);

		if (rIndex != -1) {
//			System.out.println("Device added;");
			room[rIndex].addDevice(device, ++dIndex);
			return true;
		} else {
//			System.out.println("\nRoom not exist new");
			return false;
		}
	}

	private int isRoomExist(String rt) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= index; i++) {
			if (room[i].roomType.equals(rt)) {
				return i;
			}
		}
		return -1;
	}

	public void onDevice(String rt, String dName) {
		for (int i = 0; i < 10; i++) {
			if (room[i].roomType.equals(rt)) {
				room[i].onDevice(dName);
			}
		}
	}
}
