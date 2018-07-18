package game;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class GUIController2 {
	
	@FXML GridPane grid;
	
	private Game game;
	private int ticks;
	private boolean finished;
	
	@FXML
	public void initialize() {
		grid.getChildren().clear();
		ticks = 0;
		finished = false;
		game = new Game();
		for(int x=0;x<3;x++) {
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth(100.0/3);
			grid.getColumnConstraints().add(col);
		}
		for(int y=0;y<3;y++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(100.0/3);
			grid.getRowConstraints().add(row);
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				Canvas canvas = new Canvas(100,100);
				drawEmpty(canvas);
				canvas.setOnMouseClicked(e ->
				placePiece(canvas));
				grid.add(canvas, i, j);
			}
		}
	}
	
	@FXML
	public void clearPressed() {
		ObservableList<Node> nodes = grid.getChildren();
		for(Node n:nodes) {
			drawEmpty((Canvas) n);
		}
		finished = false;
		game.clearBoard();
	}
	
	@FXML 
	public void quitPressed() {
		grid.getScene().getWindow().hide();
	}
	
	private void placePiece(Canvas pane) {
		if(!finished) {
			if(game.getTile(grid.getColumnIndex(pane), grid.getRowIndex(pane)).getType()==2) {
		if(ticks%2 ==  0) {
			drawO(pane);
			game.getTile(grid.getColumnIndex(pane), grid.getRowIndex(pane)).setType(0);
			checkFinished(ticks%2);
		}
		if(ticks%2 == 1) {
			drawX(pane);
			game.getTile(grid.getColumnIndex(pane), grid.getRowIndex(pane)).setType(1);
			checkFinished(ticks%2);
		}
		ticks++;
		}
		}
	}
	
	private void checkFinished(int w) {
		if(game.checkThree()) {
			String winner = "crosses!";
			if(w==0) {
				winner = "noughts!";
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("TicTacToe");
			alert.setHeaderText(null);
			alert.setContentText("Winner is "+winner);

			alert.showAndWait();
			finished = true;
		}
		
		int usedTiles = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if((game.getTile(i, j).getType()==0)||(game.getTile(i, j).getType()==1)) {
					usedTiles++;
				}
			}
		}
		if(usedTiles==9&&!game.checkThree()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("TicTacToe");
			alert.setHeaderText(null);
			alert.setContentText("No winner.");

			alert.showAndWait();
			finished=true;
		}
	}
	
	private void drawEmpty(Canvas canvas) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 100, 100);
		gc.setFill(Color.WHITE);
		gc.fillRect(2, 2, 96, 96);
	}
	private void drawX(Canvas canvas) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 100, 100);
		gc.setFill(Color.WHITE);
		gc.fillRect(2, 2, 96, 96);
		gc.rotate(45);
		gc.setFill(Color.BLACK);
		gc.fillRect(65, -40, 10, 80);
		gc.rotate(-90);
		gc.fillRect(-5, 30, 10, 80);
		gc.rotate(45);
	}
	private void drawO(Canvas canvas) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 100, 100);
		gc.setFill(Color.WHITE);
		gc.fillRect(2, 2, 96, 96);
		gc.setFill(Color.BLACK);
		gc.fillOval(10, 10, 80, 80);
		gc.setFill(Color.WHITE);
		gc.fillOval(20, 20, 60, 60);
	}

}
