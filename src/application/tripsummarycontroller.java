package application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class tripsummarycontroller implements Initializable{

	@FXML
    private Button cancel;

    @FXML
    private TextField car_name;

    @FXML
    private TextField car_no;

    @FXML
    private TextField destination_address;

    @FXML
    private TextField driver_name;

    @FXML
    private TextField driver_no;

    @FXML
    private TextField estimated_distance;

    @FXML
    private TextField estimated_time;

    @FXML
    private Button payment;

    @FXML
    private TextField pickup_address;

    @FXML
    private TextField price_per_seat;

    @FXML
    private TextField selected_date;

    @FXML
    private TextField selected_time;
    
    
    
    private static tripsummarycontroller instance;
    
    
    public tripsummarycontroller()
    {
    	instance = this;
    }
    
    public static tripsummarycontroller getInstance()
    {
    	return instance;
    }
   
    @FXML
    public void setTextPA(String text)
    {
    	pickup_address.setText(text);
    }
    
    @FXML
    public void setTextDA(String text)
    {
    	destination_address.setText(text);
    }
    
    
    @FXML
    public void setTextSD(String text)
    {
    	selected_date.setText(text);
    }
    
    @FXML
    public void setTextST(String text)
    {
    	selected_time.setText(text);
    }
    
       
    @FXML
    public void setTextPPS(String text)
    {
    	price_per_seat.setText(String.format("$ %s",text));
    }
    
    @FXML
    public void setTextET(String text)
    {
    	estimated_time.setText(String.format("%s minutes",text));
    }
    
    @FXML
    public void setTextED(String text)
    {
    	estimated_distance.setText(String.format("%s miles",text));
    }
    
    @FXML
    public void setTextcarno(String text)
    {
    	car_no.setText(text);
    }
    
    @FXML
    public void setTextcarname(String text)
    {
    	car_name.setText(text);
    }
    
    @FXML
    public void setTextdrivername(String text)
    {
    	driver_name.setText(text);
    }
    
    @FXML
    public void setTextdrivercontact(String text)
    {
    	driver_no.setText(text);
    }
    
    
    @FXML
    void handlePayPalButtonClick(ActionEvent event) {
        // Open the PayPal URL in the default browser
        try {
            Desktop.getDesktop().browse(new URI("https://www.paypal.com/us/signin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void home_page()
	   {
		      	
		   cancel.setOnAction(eventaction -> {
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
