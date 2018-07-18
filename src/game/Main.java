package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
	    try {
	        final FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("GUI.fxml"));
	        loader.setController(new GUIController2());
	        final Parent root = loader.load();
	        
	        final Scene scene = new Scene(root,400,310);
	        primaryStage.setTitle("TicTacToe");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    } catch(Exception e) {
	      e.printStackTrace();
	    }		
	}

	public static void main(String[] args) {
		launch(args);
	}

}

