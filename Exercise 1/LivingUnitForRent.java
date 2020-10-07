package Task_1;

import java.util.Scanner;

public class LivingUnitForRent {
	
	protected String address;
	protected double price;
	protected int numRooms ;
	

	public LivingUnitForRent() {
		this("Unknown" , 0 , 0);
	}
	
	public LivingUnitForRent(String address , int price , int numRooms) {
		setAddress(address);
		setPrice(price);
		setNumRooms(numRooms);
		
	}
	
	public void readData(Scanner sca) {
		System.out.println("what's the address?");
		setAddress(sca.next());

		System.out.println("how much the price?");
		setPrice(sca.nextInt());
		
		System.out.println("how many rooms?");
		setNumRooms(sca.nextInt());

	}

	public double getPrice() {
		return price;
	}

	public boolean setPrice(int price) {
		if (price >=0) {
			this.price = price;
			return true;
		} else {
			return false;
		}
	}
	
	public int getNumRooms() {
		return numRooms;
	}
	
	public boolean setNumRooms(int numRoom) {
		if (numRoom >=0) {
			this.numRooms = numRoom;
			return true;
		} else {
			this.numRooms = 1;
			return false;
		}
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String toString() {
		return "Living Unit For Rent:\nAddress = " + address + "\nPrice = " + price + "\nNumbers Rooms = " + numRooms;
	}
	
	
	
	
}
