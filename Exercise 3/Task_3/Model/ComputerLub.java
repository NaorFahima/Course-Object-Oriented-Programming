package Model;

import java.util.Scanner;

public class ComputerLub extends Room implements Cleanable {

	protected int numComputers ;
	private boolean isComputerLabClean;
	
	public ComputerLub() {
		this(0,0);
	}
	
	public ComputerLub(int numRoom ,int numComputers) {
		super(numRoom);
		setNumComputers(numComputers);
		isComputerLabClean = true;
	}
	

	
	public int getNumComputers() {
		return numComputers;
	}

	public boolean setNumComputers(int numComputers) {
		if (numComputers>=0) {
			this.numComputers = numComputers;
			return true;	
		} else {
			return false;
		}
	}

	public boolean isClean() {
		return isComputerLabClean;
	}

	public void clean() {
		System.out.println("Clean the Computer Lab...");
		System.out.println("The Computer Lab is clean");
		isComputerLabClean = true;

	}


	public void useIt() {
		if (!isInUse()) {
			setInUse(true);
		} 
	}


	public void releaseIt() {
		setInUse(false);
	}

	@Override
	public String toString() {
		return super.toString() +"ComputerLub [numComputers=" + numComputers + ", isComputerLabClean=" + isComputerLabClean + "]";
	}
	
	
}
