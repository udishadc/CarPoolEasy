package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class maindashboardcontroller implements Initializable{

	   @FXML
	    private Button findRide;

	   @FXML
	    private Button offerRide;

	   public void offerRide()
	   {
		      	
		   offerRide.setOnAction(eventaction -> {
		    		try {
		    			Parent root = FXMLLoader.load(getClass().getResource("offerride.fxml"));
		    			Stage stage = new Stage();
		    			Scene scene = new Scene(root);
		    			stage.setTitle("Offer a Ride");
		    			
		    			stage.setScene(scene);
		    			stage.show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	});
	   }
	   
	   
	   public void findRide()
	   {
		      	
		   findRide.setOnAction(eventaction -> {
		    		try {
		    			Parent root = FXMLLoader.load(getClass().getResource("FindRide.fxml"));
		    			Stage stage = new Stage();
		    			Scene scene = new Scene(root);
		    			stage.setTitle("Find a Ride");
		    			
		    			stage.setScene(scene);
		    			stage.show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	});
	   }
	   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	   
	   
	   

	}
	

