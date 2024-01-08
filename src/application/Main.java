package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private double x = 0;
	private double y = 0;
	private static Stage stg;
	@Override
	public void start(Stage stage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
			Scene scene = new Scene(root);
			
			/*
			 * root.setOnMousePressed((MouseEvent event) ->{ x = event.getSceneX(); y =
			 * event.getSceneY(); });
			 * 
			 * 
			 * root.setOnMouseDragged((MouseEvent event) ->{ stage.setX(event.getScreenX() -
			 * x); stage.setY(event.getScreenY() - y);
			 * 
			 * stage.setOpacity(.8); });
			 * 
			 * root.setOnMouseReleased((MouseEvent event)->{ stage.setOpacity(1);
			 * 
			 * 
			 * 
			 * });
			 */
				
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//stage.initStyle(StageStyle.TRANSPARENT);
			stage.setScene(scene);
			stage.setTitle("CarPoolEasy");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public Object changeScene(String fxml) throws Exception {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
	    Parent pane = loader.load();
	    stg.getScene().setRoot(pane);
	    return loader.getController();
	}
}
	
	/*public void changeScene(String fxml) throws Exception 
	{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}*/

