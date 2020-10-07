package Model;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;


public class Model {

	private Room room;
	private Cafeteria cafeteria;
	private ArrayList<Room> allRooms;
	private ArrayList<Cafeteria> allCafeteria;
	private ArrayList<Cleanable> allCleanable;
	
	public Model() {
		allRooms = new ArrayList<>();
		allCleanable = new ArrayList<>();
		allCafeteria =  new ArrayList<>();
		
	}
	
	public void updateModel(int kind ,int textField1,int textField2) {
		switch (kind) {
		case 1:
			room = new ClassRoom(textField1,textField2);
			allRooms.add(room);
			allCleanable.add((Cleanable) room);
			System.out.println(room);
			break;
			
		case 2:
			room = new ComputerLub(textField1,textField2);
			allRooms.add(room);
			allCleanable.add((Cleanable) room);
			System.out.println(room);
			break;
			
		case 3:
			room = new OfficeRoom(textField1);
			allRooms.add(room);
			System.out.println(room);
			break;
			
		default:
			cafeteria = new Cafeteria();
			allCleanable.add(cafeteria);
			allCafeteria.add(cafeteria);
			System.out.println(cafeteria.toString());
			break;
		}
	}
	

	
	public void updateShape(Rectangle rct) {
		allRooms.get(allRooms.size()).setRectangle(rct);
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Cafeteria getCafeteria() {
		return cafeteria;
	}

	public void setCafeteria(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}

	public ArrayList<Room> getAllRooms() {
		return allRooms;
	}

	public void setAllRooms(ArrayList<Room> allRooms) {
		this.allRooms = allRooms;
	}

	public ArrayList<Cleanable> getAllCleanable() {
		return allCleanable;
	}

	public void setAllCleanable(ArrayList<Cleanable> allCleanable) {
		this.allCleanable = allCleanable;
	}

	public ArrayList<Cafeteria> getAllCafeteria() {
		return allCafeteria;
	}

	public void setAllCafeteria(ArrayList<Cafeteria> allCafeteria) {
		this.allCafeteria = allCafeteria;
	}
}
