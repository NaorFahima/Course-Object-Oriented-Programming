package Task_2; // name : Naor Fahima    ID: 315783563

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Drow extends Application {
	
	public static final int SIZE = 800;
	public static final int BIG_SHAPE = SIZE/2;
	public static final int SMALL_SHAPE = SIZE/4;
			
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
	
		Group root = new Group();	
		
		// The biggest Shape
		Draw(root, 0, SIZE,BIG_SHAPE, BIG_SHAPE, BIG_SHAPE);
		
		// The Smallest Shape left corner top
		Draw(root, 0, BIG_SHAPE,SMALL_SHAPE, SMALL_SHAPE, SMALL_SHAPE);

		// The Smallest Shape left corner Bottom
		Draw(root, 0, BIG_SHAPE ,SMALL_SHAPE*3, SMALL_SHAPE, SMALL_SHAPE);

		// The Smallest Shape right corner top 
		Draw(root, BIG_SHAPE, SIZE, SMALL_SHAPE, SMALL_SHAPE*3, SMALL_SHAPE);
		
        // The Smallest Shape right corner bottom 
		Draw(root, BIG_SHAPE, SIZE ,SMALL_SHAPE*3 ,SMALL_SHAPE*3, SMALL_SHAPE);
		
		Scene scene = new Scene(root, SIZE, SIZE);
		scene.setFill(Color.DARKBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void Draw(Group root ,int startXLeft ,int startXRight ,int startY , int endX, int maxLoop) {	
		for (int i = 0; i <= maxLoop; i +=20) {
			// Top-Left
			Line line = new Line(startXLeft + i, startY, endX, startY - i);
			
			// bottom-Left
			Line line1 = new Line(startXLeft + i, startY, endX, startY + i);
			
			// top-Right
			Line line2 = new Line(startXRight - i, startY, endX, startY - i);

			// Bottom-Right
			Line line3 = new Line(startXRight - i, startY, endX, startY + i);
			
			line.setStroke(Color.WHITE);
			line1.setStroke(Color.WHITE);
			line2.setStroke(Color.WHITE);
			line3.setStroke(Color.WHITE);
			root.getChildren().addAll(line ,line1 ,line2, line3 );
		}
	}

}
