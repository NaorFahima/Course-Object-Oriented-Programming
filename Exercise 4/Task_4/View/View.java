package View_4;


import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
	
	private Button bBroadcasting, bContine;
	private RadioButton rbReportage , rbInterview ,rbSong;
	private ToggleGroup tgr;
	private Scene scene;
	private Stage stage;
	private int kind;
	private Text title,start,duration,author,band,participant;
	private TextField textField1,textField2,textField3,textField4,textField5;
	private GridPane gridPane;
	private BorderPane bp;
	private VBox vb;
	private Rectangle rectangle ;
	private Group root;
	private ArrayList<Rectangle> rectangles;
	private final int STARTX=50,STARTY=150,HEIGHT=150,END=350;
	
	public View(Stage stage) {
		this.stage = stage;
		root = new Group();
		tgr = new ToggleGroup();
		bp = new BorderPane();
		vb = new VBox();
		rectangles = new ArrayList<Rectangle>();
		

		
		bContine = new Button("Contine");
		bBroadcasting = new Button("Add Broadcasting");
		BorderPane.setMargin(bBroadcasting, new javafx.geometry.Insets(40, 0, 0, 220));
		
		
		
		// Rectangle
		rectangle = new Rectangle(STARTX,STARTY,END-STARTX, HEIGHT);
		rectangle.setFill(null);
		rectangle.setStroke(Color.BLACK);
		rectangles.add(rectangle);
		root.getChildren().add(rectangle);
		
		
		
		// vBox
		rbReportage = new RadioButton("Reportage");
		rbInterview = new RadioButton("Interview");
		rbSong = new RadioButton("Song");
		rbReportage.setToggleGroup(tgr);
		rbInterview.setToggleGroup(tgr);
		rbSong.setToggleGroup(tgr);
		vb.getChildren().addAll(rbReportage ,rbInterview, rbSong);
		VBox.setMargin(rbReportage, new javafx.geometry.Insets(20, 20, 20, 20));
		VBox.setMargin(rbInterview, new javafx.geometry.Insets(20, 20, 20, 20));
		VBox.setMargin(rbSong, new javafx.geometry.Insets(20, 20, 20, 20));
	
		
		// Title
		title=new Text("Title");
		start=new Text("Start");
		duration=new Text("Duration");
		author=new Text("Author");
		band=new Text("Band");
		participant=new Text("Participant");
		
		
		// TextField
		textField1 = new TextField();          
		textField2 = new TextField();
		textField3 = new TextField();
		textField4 = new TextField();
		textField5 = new TextField();
	
		bp.setTop(bBroadcasting);
		bp.setCenter(root);
		scene = new Scene(bp,600,600);
		stage.setScene(scene);
		stage.show();	
	

	}
	
	public void openNewWindow() {
		root.getChildren().clear();
		bp.setLeft(vb);
		bp.setBottom(bContine);	
	}
	
	public void updateViewAfterOk() {
		root.getChildren().clear();
		bp.setLeft(null);
		bp.setBottom(null);
		root.getChildren().addAll(rectangles);
		
	}
	
	public void updateViewToggleGroup() {
		root.getChildren().clear();
		textField1.clear();
		textField2.clear();
		textField3.clear();
		textField4.clear();
		textField5.clear();
		
		gridPane = new GridPane();
		gridPane.setMinSize(300, 250);
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		
		gridPane.add(title, 0, 0);
		gridPane.add(textField1, 1, 0);
		gridPane.add(start, 0, 1);
		gridPane.add(textField2, 1, 1);	
		gridPane.add(duration, 0, 2);
		gridPane.add(textField3, 1, 2);	
		gridPane.setStyle("-fx-background-color: rgb(200,0,50);");
		if (kind == 1 || kind == 2) {
		gridPane.add(author, 0, 3);
		gridPane.add(textField4, 1, 3);	
		}
		if (kind == 2) {
			gridPane.add(participant, 0, 4);
			gridPane.add(textField5, 1, 4);	
			gridPane.setStyle("-fx-background-color: rgb(100,100,0);");
		}
		if (kind == 3) {
			gridPane.add(band, 0, 3);
			gridPane.add(textField4, 1, 3);	
			gridPane.setStyle("-fx-background-color: rgb(0,200,100);");
		}
	
		gridPane.add(bContine, 1, 5);
		
		root.getChildren().add(gridPane);	
		bp.setCenter(root);
	}
	
	public void updateShape(double start,double width,Color color) {
		Rectangle rc=new Rectangle(STARTX+(start*5), STARTY, width*5, HEIGHT);
		rc.setFill(color);
		rectangles.add(rc);	
	}

	
	
	
	public Button getbBroadcasting() {
		return bBroadcasting;
	}

	public void setbBroadcasting(Button bBroadcasting) {
		this.bBroadcasting = bBroadcasting;
	}

	public RadioButton getRbReportage() {
		return rbReportage;
	}

	public void setRbReportage(RadioButton rbReportage) {
		this.rbReportage = rbReportage;
	}

	public RadioButton getRbInterview() {
		return rbInterview;
	}

	public void setRbInterview(RadioButton rbInterview) {
		this.rbInterview = rbInterview;
	}

	public RadioButton getRbSong() {
		return rbSong;
	}

	public void setRbSong(RadioButton rbSong) {
		this.rbSong = rbSong;
	}


	public ToggleGroup getTgr() {
		return tgr;
	}

	public void setTgr(ToggleGroup tgr) {
		this.tgr = tgr;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}



	public Button getbContine() {
		return bContine;
	}

	public void setbContine(Button bContine) {
		this.bContine = bContine;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
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

	public TextField getTextField3() {
		return textField3;
	}

	public void setTextField3(TextField textField3) {
		this.textField3 = textField3;
	}

	public TextField getTextField4() {
		return textField4;
	}

	public void setTextField4(TextField textField4) {
		this.textField4 = textField4;
	}

	public TextField getTextField5() {
		return textField5;
	}

	public void setTextField5(TextField textField5) {
		this.textField5 = textField5;
	}




	
	
	
	


}
