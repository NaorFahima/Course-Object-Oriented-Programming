package Model;

import java.util.Scanner;

import javafx.scene.shape.Rectangle;

public abstract class Room {
	
	protected int numRoom;
	protected boolean isInUse;
	protected Rectangle rectangle;
	
	public Room() {
		this(0);
	}
	
	public Room(int numRoom) {
		setNumRoom(numRoom);
		setInUse(false);
	}
	
	public abstract void useIt();
	
	public abstract void releaseIt();


	public int getNumRoom() {
		return numRoom;
	}

	public boolean setNumRoom(int numRoom) {
		if (numRoom>=0) {
			this.numRoom = numRoom;
			return true;	
		} else {
			return false;
		}
	}

	public boolean isInUse() {
		return isInUse;
	}

	public void setInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}
	
	public void readDate(Scanner sca) {
		System.out.println("number of room?");
		numRoom = sca.nextInt();
	}

	public String toString() {
		return "Room [numRoom=" + numRoom + ", isInUse=" + isInUse + "]";
	}

	public Rectangle getRectangle() {
		return rectangle;
	}
	

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	
	
	
}
