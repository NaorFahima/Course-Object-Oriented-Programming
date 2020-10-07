package Controller;


import Model.ClassRoom;
import Model.ComputerLub;
import Model.OfficeRoom;
import Model.Room;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
	
	private Model.Model theModel;
	private View.View theView;
	private boolean isRoom;
	

	public Controller(Model.Model model,View.View view) {
		theModel = model;
		theView = view;
	
		theView.getbContine().setOnAction(e ->{
			theView.getWindow().close();
			theModel.updateModel(theView.getKindDrow(),Integer.parseInt(theView.getTextField1().getText()),Integer.parseInt(theView.getTextField2().getText()));
			switch (theView.getKindDrow()) {
			case 1:
				theView.drawClassRoom(theModel);
				System.out.println("ClassRoom has been Add");
				break;
			case 2:
				theView.drawComputerLab(theModel);
				System.out.println("ComputerLab has been Add");
				break;
			case 3:
				theView.drawOfficeRoom(theModel);
				System.out.println("OfficeRoom has been Add");
				break;
			default:
				break;
			}

			theView.addEventHandlerToRoom(theModel.getAllRooms().get(theModel.getAllRooms().size()-1).getRectangle(),new EventHandler<MouseEvent>() {
				private Room room;
				
				public void handle(MouseEvent event) {
					
					for (int i = 0; i < theModel.getAllRooms().size(); i++) {
						if (event.getTarget().equals(theModel.getAllRooms().get(i).getRectangle())) {
							isRoom = true;
							if (theModel.getAllRooms().get(i) instanceof ClassRoom) {
								ClassRoom room = (ClassRoom) theModel.getAllRooms().get(i);
								this.room = (Room) room;
								theView.inputData(0,"Options","Number of Room : "+room.getNumRoom(),"Number of Seats : "+room.getNumSeats(),"In Use: "+room.isInUse());
							}
							else if (theModel.getAllRooms().get(i) instanceof ComputerLub) {
								ComputerLub room = (ComputerLub) theModel.getAllRooms().get(i);
								this.room = room;
								theView.inputData(0,"Options","Number of Room : "+ room.getNumRoom(), "Number of Computers : "+ room.getNumComputers(),"In Use: "+room.isInUse());
							} else if (theModel.getAllRooms().get(i) instanceof OfficeRoom) {
								OfficeRoom room = (OfficeRoom) theModel.getAllRooms().get(i);
								this.room = room;
								theView.inputData(0,"Options","Number of Room : "+ room.getNumRoom(), "Number of employees : "+ room.getNumOfPeople()+"\n"+room.printNames(),"In Use: "+room.isInUse());
							} 
							
						
							theView.getbChoice().setOnAction(e -> {
								isRoom = false;
								theView.getWindow().close();
								if (theView.getChoiceBox().getValue().equals("Clean")) {
									theView.changeColor(room);
								} else if (theView.getChoiceBox().getValue().equals("Use")) {
									if (room instanceof OfficeRoom) {
										theView.readEmployed((OfficeRoom) room);
										room.useIt();
									} 
									else {
										room.useIt();
									} 
										
								} else if (theView.getChoiceBox().getValue().equals("Releas")) {
									if (room.isInUse()) {
										room.releaseIt();
										room.getRectangle().setFill(Color.DARKSLATEGREY);
									}
								}
							});
							
						}		
					}
				}
			});	
		
		});
		
		
		theView.getbClassRoom().setOnAction(e ->{
			theView.setKindDrow(1); // kind ClassRoom = 1
			theView.inputData(1,"Add ClassRoom","Number of Room","Number of Seats","");
		});
		
		theView.getbChoice().setOnAction(e -> {
			theView.getWindow().close();
		});
		
		theView.getbComputerLab().setOnAction(e ->{
			theView.setKindDrow(2); // kind ComputerLab = 2
			theView.inputData(1,"Add ComputerLab","Number of Room","Number of Computers","");
		});
		
		theView.getbOfficeRoom().setOnAction(e ->{
			theView.setKindDrow(3); // kind OfficeRoom = 3
			theView.inputData(1,"Add OfficeRoom","Number of Room","","");
		});
		
		theView.getbCafeteria().setOnAction(e ->{
			theView.setKindDrow(4);  // kind Cafeteria = 4
			theModel.updateModel(theView.getKindDrow(),0,0);
			theView.drawCafeteria(theModel);
			System.out.println("Cafeteria has been Add");
		});

		}
	}
