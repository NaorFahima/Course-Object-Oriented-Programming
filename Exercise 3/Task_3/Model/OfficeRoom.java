package Model;

import java.util.Arrays;
import java.util.Scanner;

public class OfficeRoom extends Room {

	protected String[] allNames;
	protected int numOfPeople;
	protected final int PEOPLE_MAX = 5;

	public OfficeRoom() {
		this(0);
	}
	
	public OfficeRoom(int numRoom) {
		super(numRoom);
		allNames = new String[PEOPLE_MAX];
		setNumOfPeople(numOfPeople);
		
	}
	
	
	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public String[] getAllNames() {
		return allNames;
	}

	public void setAllNames(String[] allNames) {
		this.allNames = allNames;
	}

	public int getPEOPLE_MAX() {
		return PEOPLE_MAX;
	}
	public void useIt() {
		if (!isInUse()) {
			setInUse(true);
		} 
	}
	public void releaseIt() {
		setInUse(false);

	}
	
	public String printNames() {
		return Arrays.toString(allNames);
	}

	public String toString() {
		return super.toString() + "OfficeRoom [allNames=" + Arrays.toString(allNames) + ", numOfPeople=" + numOfPeople + ", PEOPLE_MAX="
				+ PEOPLE_MAX + "]";
	}
}
