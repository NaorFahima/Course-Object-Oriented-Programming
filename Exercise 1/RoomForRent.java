package Task_1;

import java.util.Scanner;

public class RoomForRent extends AppartmentForRent{

	protected double priceRoom;

	public RoomForRent() {
		super();
		setPriceRoom();
	}

	public RoomForRent(String address, int price, int numRoom, int floor) {
		super(address, price, numRoom, floor);
		setPriceRoom();
	}

	public void readData(Scanner sca) {
		super.readData(sca);
		setPriceRoom();
	}

	public double getPriceRoom() {
		return priceRoom;
	}

	public void setPriceRoom() {	
		int numRooms = getNumRooms();
		this.priceRoom = super.price/numRooms;
		
	}


	public String toString() {
		return super.toString() +  "\nPrice for Room = " + priceRoom;
	}
	
	
	
	

	


	
	
	
}
