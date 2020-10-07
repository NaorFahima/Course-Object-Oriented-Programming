package Model;


import javafx.scene.shape.Rectangle;

public class Cafeteria implements Cleanable {


	private boolean isCafeteriaClean;
	private Rectangle rectangle;
	private boolean isInUse;
	
	public Cafeteria() {
		isCafeteriaClean = true;
	}
	
	public void clean() {
		System.out.println("Start clean the Cafeteria");
		isCafeteriaClean = true;
	}

	
	public boolean isClean() {
		return isCafeteriaClean;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public String toString() {
		return "Cafeteria [isCafeteriaClean=" + isCafeteriaClean +"]";
	}

	public boolean isInUse() {
		return isInUse;
	}

	public void setInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}
	
	
	

	

}
