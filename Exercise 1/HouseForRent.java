package Task_1;

import java.util.Scanner;

public class HouseForRent extends LivingUnitForRent {

	protected boolean poolInTheHouse;
	protected boolean gardenInTheHouse;
	protected int numberOfFloors;

	
	public HouseForRent() {
		this("Unknown" , 0 , 0 , 0 , false , false);
	}
	
	public HouseForRent(String address, int price, int numRooms ,int numberOfFloors , boolean poolInTheHouse ,boolean gardenInTheHouse ) {
		super(address, price, numRooms);
		setNumberOfFloors(numberOfFloors);
		this.poolInTheHouse = poolInTheHouse;
		this.gardenInTheHouse = gardenInTheHouse;
		
	}

	public void readData(Scanner sca) {
		int menuSelect;
		super.readData(sca);
		System.out.println("There is a pool at home? \n(1) Yes \n(2) No");
		menuSelect = sca.nextInt();
		poolInTheHouse = ((menuSelect == 1) ? true:false);

		System.out.println("There is a garden at home? \n(1) Yes \n(2) No");
		menuSelect = sca.nextInt();
		gardenInTheHouse = ((menuSelect == 1) ? true:false);
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean setNumberOfFloors(int numberOfFloors) {
		if (numberOfFloors >=0) {
			this.numberOfFloors = numberOfFloors;
			return true;
		} else {
			return false;
		}
	}

	public boolean isPoolInTheHouse() {
		return poolInTheHouse;
	}

	public boolean isGardenInTheHouse() {
		return gardenInTheHouse;
	}

	public String toString() {
		return super.toString() + "\nHouse For Rent: \nPool In The House = " + poolInTheHouse + "\nGarden In The House = " + gardenInTheHouse;
	}
	
	
	
	
	
	
}
