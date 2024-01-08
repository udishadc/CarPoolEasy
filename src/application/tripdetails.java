package application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class tripdetails implements Initializable{

    @FXML
    private TextField destination_address;

    @FXML
    private TextField estimated_distance;

    @FXML
    private TextField estimated_time;

    @FXML
    private TextField pickup_address;

    @FXML
    private TextField price_per_seat;

    @FXML
    private TextField seats;

    @FXML
    private TextField selected_date;

    @FXML
    private TextField selected_time;
    
    @FXML
    private Button login_page;
    
    private static tripdetails instance;
    
    
    public tripdetails()
    {
    	instance = this;
    }
    
    public static tripdetails getInstance()
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
    public void setTextSeats(String text)
    {
    	seats.setText(text);
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
    
    public void login_page()
    {
    	
    	login_page.setOnAction(eventaction -> {
    		try {
    			Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    			Stage stage = new Stage();
    			Scene scene = new Scene(root);
    			stage.setTitle("CarPoolEasy");    			
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

		  