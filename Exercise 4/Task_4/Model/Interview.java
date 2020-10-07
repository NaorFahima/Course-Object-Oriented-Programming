package Model_4;

import javafx.scene.paint.Color;

public class Interview extends Broadcasts {
	
	protected String author;
	protected String participants;
	protected final static Color COLOR = Color.rgb(100,100,0);
	
	public Interview(String title, int start, int duration ,String author , String participants) {
		super(title, start, duration,COLOR);
		setAuthor(author);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return super.toString()+"Interview [author=" + author + ", participants=" + participants + "]";
	}

	
	

	
	

}
