package Model_4;

import javafx.scene.paint.Color;

public class Song extends Broadcasts {

	protected String bond;
	protected final static Color COLOR = Color.rgb(100,100,0);
	
	
	public Song(String title, int start, int duration ,String bond) {
		super(title, start, duration,COLOR);
		setBond(bond);
	}

	public String getBond() {
		return bond;
	}

	public void setBond(String bond) {
		this.bond = bond;
	}

	@Override
	public String toString() {
		return	super.toString()+ "Song [bond=" + bond + "]";
	}


	
	

}
