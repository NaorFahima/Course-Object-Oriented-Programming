package Controller_4;


import Model_4.Model;
import View_4.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;


public class Controller {
	
	private Model theModel;
	private View theView;

	public Controller(Model_4.Model model,View_4.View view) {
		theModel = model;
		theView = view;
		
ChangeListener<Toggle> cl = new ChangeListener<Toggle>() {

			
public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton rb =(RadioButton)theView.getTgr().getSelectedToggle();
				
				if (rb == theView.getRbReportage()) {
					theView.setKind(1);
				} 
				if (rb == theView.getRbInterview()) {
					theView.setKind(2);
				} 
				if (rb == theView.getRbSong()) {
					theView.setKind(3);
				}
				
				theView.updateViewToggleGroup();
			
				theView.getbContine().setOnAction(new EventHandler<ActionEvent>(){

					
					public void handle(ActionEvent event) {
						theModel.makeBroadCasts(theView.getKind() ,view.getTextField1().getText(),
								Integer.parseInt(view.getTextField2().getText()), Integer.parseInt(view.getTextField3().getText()), view.getTextField4().getText(), view.getTextField5().getText());
						
						Model_4.Broadcasts b =theModel.getCurrentBroadcasts();
						theView.updateShape(b.getStart(), b.getDuration(), b.getColor());
						theView.updateViewAfterOk();
					}
					
				});
				
			}
			
		};
		theView.getTgr().selectedToggleProperty().addListener(cl);
		
		

		
		theView.getbBroadcasting().setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				theView.openNewWindow();
				theView.setKind(1);
				theView.getTgr().selectToggle(theView.getRbReportage());
				theView.updateViewToggleGroup();
			}
		});
		
		

	}
}
