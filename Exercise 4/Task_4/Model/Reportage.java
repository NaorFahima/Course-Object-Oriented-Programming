package Model_4;

import javafx.scene.paint.Color;

public class Reportage extends Broadcasts {
	
	protected String author;
	protected final static Color COLOR = Color.rgb(200,0,50);
	
	public Reportage(String title, int start, int duration , String author) {
		super(title, start, duration, COLOR);
		setAuthor(author);
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return super.toString() +"Reportage [author=" + author + "]";
	}
	
	

}
