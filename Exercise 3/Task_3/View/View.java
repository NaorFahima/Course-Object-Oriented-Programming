package View;


import java.util.ArrayList;

import Model.Cafeteria;
import Model.ClassRoom;
import Model.ComputerLub;
import Model.Model;
import Model.OfficeRoom;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
	
	private Button bClassRoom , bComputerLab ,bOfficeRoom , bCafeteria ,bContine, bChoice;
	private Group root;
	private Scene scene ,sceneData;
	private BorderPane borderPane;
	private VBox vb1,vb2,vb3,vb4;
	private Stage window;
	private GridPane gridPane;
	private Text text1,text2,text3;
	private TextField textField1,textField2,textField3,textField4,textField5;
	private ChoiceBox<String> choiceBox;
	private DropShadow dShadow;
	private int kindDrow;
	private final Color COLOR_CLASS = Color.MEDIUMBLUE;
	private final Color COLOR_OFFICE = Color.CRIMSON;
	private final Color COLOR_COUMPUTER_LAB = Color.DARKORANGE;
	private final Color COLOR_CAFETERIA = Color.DARKGREEN;
	private ArrayList<Rectangle> allRectangle;
	
	public View(Stage stage) {
		root = new Group();
		borderPane = new BorderPane();
		allRectangle = new ArrayList<Rectangle>();
		choiceBox = new ChoiceBox<String>();
		choiceBox.getItems().addAll("Clean","Use","Releas");
		
		
		vb1 = new VBox();
		vb2 = new VBox();
		vb3 = new VBox();
		vb4 = new VBox();
	
		bClassRoom = new Button("Add ClassRoom");
		bComputerLab = new Button("Add ComputerLab");
		bOfficeRoom = new Button("Add OfficeRoom");
		bCafeteria = new Button("Add Cafeteria");
		bContine = new Button("Confirm");
		bChoice = new Button("Click Me");
		
		HBox hb = new HBox();
		hb.getChildren().addAll(bClassRoom,bComputerLab,bOfficeRoom,bCafeteria);
		HBox.setMargin(bClassRoom, new Insets(20,20,20,20));
		HBox.setMargin(bComputerLab, new Insets(20,20,20,20));
		HBox.setMargin(bOfficeRoom, new Insets(20,20,20,20));
		HBox.setMargin(bCafeteria, new Insets(20,20,20,20));
		
		dShadow = new DropShadow();
		dShadow.setOffsetX(10);
	
		
     	borderPane.setTop(hb);
     	root.getChildren().addAll(vb1,vb2,vb3,vb4);
		scene = new Scene(borderPane,680,800);
		stage.setScene(scene);
		stage.show();	
	}
	
	public void readEmployed(OfficeRoom office) {
		window = new Stage();
		
		gridPane = new GridPane(); 
		gridPane.setMinSize(400, 300);
		gridPane.setPadding(new Insets(50, 40, 0, 70));
		gridPane.setVgap(10);
		gridPane.setHgap(10);

		text1 = new Text("Names of employed: (max 5)");
		
		textField1 = new TextField();
		textField2 = new TextField();
		textField3 = new TextField();
		textField4 = new TextField();
		textField5 = new TextField();
		
		gridPane.add(text1, 0, 0);
		gridPane.add(textField1, 1, 0);
		gridPane.add(textField2, 1, 1);
		gridPane.add(textField3, 1, 2);
		gridPane.add(textField4, 1, 3);
		gridPane.add(textField5, 1, 4);
		gridPane.add(bContine, 1, 5);
			
		office.getAllNames()[0] = textField1.getText();
		office.getAllNames()[1] = textField2.getText();
		office.getAllNames()[2] = textField3.getText();
		office.getAllNames()[3] = textField4.getText();
		office.getAllNames()[4] = textField5.getText();
		
		bContine.setOnAction(e -> window.close());
		
		sceneData = new Scene(gridPane);
		window.setScene(sceneData);
		window.show();
		
	}
	
	public void inputData(int choose ,String title ,String firstMassege , String secondMassege ,String ThirdMassege) {
		window = new Stage();
		
		text1 = new Text(firstMassege);
		text2 = new Text(secondMassege);
		text3 = new Text(ThirdMassege);
		text3 = new Text(ThirdMassege);
		textField1 = new TextField();          
		textField2 = new TextField();
		
		
		window.setTitle(title);
		gridPane = new GridPane(); 
		gridPane.setMinSize(400, 200);
		gridPane.setPadding(new Insets(50, 40, 0, 70));
		gridPane.setVgap(10);
		gridPane.setHgap(10);

		if (choose == 1) {
			gridPane.add(text1, 0, 0);
			gridPane.add(textField1, 1, 0);
			if (kindDrow !=3) {
				gridPane.add(text2, 0, 1);
				gridPane.add(textField2, 1, 1);	
			}
			if (kindDrow == 3) {
				textField2.setText("0");
			}
			gridPane.add(bContine, 1, 2);
		} else {
			gridPane.add(choiceBox, 0, 0);
			gridPane.add(bChoice, 0, 1);
			gridPane.add(text1, 1, 0);
			gridPane.add(text2, 1, 1);
			gridPane.add(text3, 1, 2);
		}	
		sceneData = new Scene(gridPane);
		window.setScene(sceneData);
		window.show();	
	}
	
	
	public void drawClassRoom(Model model) {
		Rectangle rct = new Rectangle(70,70,COLOR_CLASS);
		allRectangle.add(rct);
		model.getAllRooms().get(model.getAllRooms().size()-1).setRectangle(rct);
		rct.addEventHandler(MouseEvent.ANY, e ->{
			if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
				rct.setEffect(dShadow);
			} 
			if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
				rct.setEffect(null);
			}
		});
		vb1.getChildren().add(rct);
		vb1.setMargin(rct, new Insets(10,20,20,40));
		borderPane.setLeft(root);	
	}
	
	public void drawComputerLab(Model model) {
		Rectangle rct = new Rectangle(70,70,COLOR_COUMPUTER_LAB);
		allRectangle.add(rct);
		model.getAllRooms().get(model.getAllRooms().size()-1).setRectangle(rct);
		rct.addEventHandler(MouseEvent.ANY, e ->{
			if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
				rct.setEffect(dShadow);
			} 
			if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
				rct.setEffect(null);
			}
		});
		vb2.getChildren().add(rct);
		vb2.setMargin(rct, new Insets(10,20,20,220));
		borderPane.setLeft(root);	
	}
	
	public void drawOfficeRoom(Model model) {
		Rectangle rct = new Rectangle(70,70,COLOR_OFFICE);
		allRectangle.add(rct);
		model.getAllRooms().get(model.getAllRooms().size()-1).setRectangle(rct);
		rct.addEventHandler(MouseEvent.ANY, e ->{
			if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
				rct.setEffect(dShadow);
			} 
			if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
				rct.setEffect(null);
			}
		});
		vb3.getChildren().add(rct);
		vb3.setMargin(rct, new Insets(10,20,20,400));
		borderPane.setLeft(root);	
	}
	
	public void drawCafeteria(Model model) {
		Rectangle rct = new Rectangle(70,70,COLOR_CAFETERIA);
		allRectangle.add(rct);
		rct.addEventHandler(MouseEvent.ANY, e ->{
			if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
				rct.setEffect(dShadow);
			} 
			if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
				rct.setEffect(null);
			}
			if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
				inputData(0,"Options","Cafeteria","In Use : "+model.getAllCafeteria().get(model.getAllCafeteria().size()-1).isInUse(),"");
			}
		});
		model.getAllCafeteria().get(model.getAllCafeteria().size()-1).setRectangle(rct);
		vb4.getChildren().add(rct);
		vb4.setMargin(rct, new Insets(10,20,20,560));
		borderPane.setLeft(root);	
	}
	
	public void changeColor(Object objact) {
		if (objact instanceof ClassRoom) {
			((ClassRoom) objact).getRectangle().setFill(COLOR_CLASS);
		}
		else if (objact instanceof ComputerLub) {
			((ComputerLub) objact).getRectangle().setFill(COLOR_COUMPUTER_LAB);
		} 
		else if (objact instanceof OfficeRoom) {
			((OfficeRoom) objact).getRectangle().setFill(COLOR_OFFICE);
		} else {
			((Cafeteria) objact).getRectangle().setFill(COLOR_CAFETERIA);
		}	
	}
	
	public void addEventHandlerToRoom(Rectangle rct , EventHandler<MouseEvent> event) {
		rct.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
	}
	
	public void addEventHandlerToCafeteria(Rectangle rct , EventHandler<MouseEvent> event) {
		rct.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
	}

	public Button getbClassRoom() {
		return bClassRoom;
	}

	public void setbClassRoom(Button bClassRoom) {
		this.bClassRoom = bClassRoom;
	}

	public Button getbComputerLab() {
		return bComputerLab;
	}

	public void setbComputerLab(Button bComputerLab) {
		this.bComputerLab = bComputerLab;
	}

	public Button getbOfficeRoom() {
		return bOfficeRoom;
	}

	public void setbOfficeRoom(Button bOfficeRoom) {
		this.bOfficeRoom = bOfficeRoom;
	}

	public Button getbCafeteria() {
		return bCafeteria;
	}

	public void setbCafeteria(Button bCafeteria) {
		this.bCafeteria = bCafeteria;
	}

	public Button getbContine() {
		return bContine;
	}

	public void setbContine(Button bContine) {
		this.bContine = bContine;
	}

	public Button getbChoice() {
		return bChoice;
	}

	public void setbChoice(Button bChoice) {
		this.bChoice = bChoice;
	}

	public TextField getTextField1() {
		return textField1;
	}

	public void setTextField1(TextField textField1) {
		this.textField1 = textField1;
	}

	public TextField getTextField2() {
		return textField2;
	}

	public void setTextField2(TextField textField2) {
		this.textField2 = textField2;
	}

	public ChoiceBox<String> getChoiceBox() {
		return choiceBox;
	}

	public void setChoiceBox(ChoiceBox<String> choiceBox) {
		this.choiceBox = choiceBox;
	}

	public int getKindDrow() {
		return kindDrow;
	}

	public void setKindDrow(int kindDrow) {
		this.kindDrow = kindDrow;
	}

	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}

	public ArrayList<Rectangle> getAllRectangle() {
		return allRectangle;
	}

	public void setAllRectangle(ArrayList<Rectangle> allRectangle) {
		this.allRectangle = allRectangle;
	}
	
}
