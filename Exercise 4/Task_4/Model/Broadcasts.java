package Model_4;

import javafx.scene.paint.Color;

public class Broadcasts {
	
	protected String title;
	protected int start;
	protected int duration;
	protected Color color;
	protected final int MAX_DURATION=60;

	public Broadcasts(String title ,int start,int duration ,Color color) {
		this.title = title;
		this.start = start;
		this.duration = duration;
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	public String toString() {
		return "Broadcasts [title=" + title + ", start=" + start + ", duration=" + duration 
				+ "]";
	}
	
	public boolean checkTime(int duration,int start) {
		if(duration+start<=MAX_DURATION) {
			this.duration=duration;
			this.start=start;
			return true;
		}
		return false;
	}

	

	

	
	
}
