package Program_4; // name : Naor Fahima    ID: 315783563


import javafx.application.Application;
import javafx.stage.Stage;

public class Program_4  extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage stage) throws Exception {
		Model_4.Model model = new Model_4.Model();
		View_4.View view = new View_4.View(stage);
		Controller_4.Controller Controller = new Controller_4.Controller(model, view);
	}
	


}
