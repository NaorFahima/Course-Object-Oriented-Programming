package Task_1;

import java.util.Scanner;

public class AppartmentForRent extends LivingUnitForRent {
	
	protected int floor;
	
	
	public AppartmentForRent() {
		this("Unknown", 0, 0, 0);
	}
	
	
	public AppartmentForRent(String address, int price, int numRooms ,int floor ) {
		super(address, price, numRooms);
		setFloor(floor);
	}

	public void readData(Scanner sca) {
		super.readData(sca);
		System.out.println("Which floor?");
		setFloor(sca.nextInt());
	}
	
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}


	public String toString() {
		return super.toString() + "\nAppartment For Rent :\nNumbers Floor = " + floor;
	}
	
	
	
	
	
	

}
