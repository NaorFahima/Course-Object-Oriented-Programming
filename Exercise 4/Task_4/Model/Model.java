package Model_4;

import java.util.ArrayList;


public class Model {
	
	private ArrayList<Broadcasts> allBroadcasts;
	private Broadcasts currentBroadcasts;
	public Model() {
		allBroadcasts = new ArrayList<Broadcasts>();
	}
	
	public void makeBroadCasts(int kind , String textfield1 , int textfield2 , int textfield3 , String textfield4 , String textfield5 ) {
		if (checkTime(textfield2, textfield3)) {
			
		
		switch (kind) {
		case 1:
			Reportage reportage = new Reportage(textfield1, textfield2, textfield3, textfield4);
			allBroadcasts.add(reportage);
			System.out.println(reportage);
			break;
		case 2:
			Interview interview = new Interview(textfield1, textfield2, textfield3, textfield4, textfield5);
			allBroadcasts.add(interview);
			System.out.println(interview);
			break;
		case 3:
			Song song = new Song(textfield1, textfield2, textfield3, textfield4);
			allBroadcasts.add(song);
			System.out.println(song);
			break;
		default:
			break;
		}
		
		currentBroadcasts = allBroadcasts.get(allBroadcasts.size()-1);
		
		} else {
			System.out.println("ERROR !! There is another broadcast at this time...");
		}
		
	}

	public ArrayList<Broadcasts> getAllBroadcasts() {
		return allBroadcasts;
	}

	public void setAllBroadcasts(ArrayList<Broadcasts> allBroadcasts) {
		this.allBroadcasts = allBroadcasts;
	}

	public Broadcasts getCurrentBroadcasts() {
		return currentBroadcasts;
	}

	public void setCurrentBroadcasts(Broadcasts currentBroadcasts) {
		this.currentBroadcasts = currentBroadcasts;
	}
	
	
	public boolean checkTime(int start,int duration) {
		for(int i=0;i<allBroadcasts.size();i++) {
			if(!allBroadcasts.isEmpty()) {
				if(allBroadcasts.get(i).getStart()<start&&start<(allBroadcasts.get(i).getDuration()+allBroadcasts.get(i).getStart())){
					return false;
				}
				if((allBroadcasts.get(i).getStart()>start)&&(duration+start)>(allBroadcasts.get(i).getDuration()+allBroadcasts.get(i).getStart())) {
					return false;
				}
				if(duration+start>allBroadcasts.get(i).getStart()&&duration+start<(allBroadcasts.get(i).getDuration()+allBroadcasts.get(i).getStart())) {
					return false;
				}
			}

		}
		return true;
	}
	

}
