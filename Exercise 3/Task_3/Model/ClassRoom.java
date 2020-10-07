package Model;

import java.util.Scanner;

public class ClassRoom extends Room implements Cleanable {

	protected int numSeats;
	private boolean isRoomClean;
	
	public ClassRoom() {
		this(0,0);
	}
	
	public ClassRoom(int numRoom , int numSeats) {
		super(numRoom);
		setNumSeats(numSeats);
		isRoomClean = true;
	}
	

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public boolean isClean() {
		return isRoomClean;
	}

	public void clean() {
		System.out.println("Clean the room...");
		System.out.println("The room is clean");
		isRoomClean = true;
	}


	public void releaseIt() {
		setInUse(false);
	}

	public void useIt() {
		if (!isInUse()) {
			setInUse(true);
		} 
	}
	

	public String toString() {
		return super.toString() +"ClassRoom [numSeats=" + numSeats + ", isRoomClean=" + isRoomClean + "]";
	}

	
	
	




}
