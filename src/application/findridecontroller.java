package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class findridecontroller implements Initializable{
	
	@FXML
    private Button datebtn;

    @FXML
    private TextField drop_searchBox;

    @FXML
    private Spinner<Integer> hour_spinner;

    @FXML
    private Button load_map;

    @FXML
    private Spinner<Integer> min_spinner;

    @FXML
    private TextField pickup_searchBox;

    @FXML
    private Button searchbtn;

    @FXML
    private Button timebtn;

    @FXML
    private TextField trip_date;

    @FXML
    private TextField trip_time;

    @FXML
    private WebView webView;
    
    private WebEngine engine;
    
    DatePicker datePicker = new DatePicker();
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    
    //tripsummarycontroller ts = tripsummarycontroller.getInstance();
    /*@FXML
    private void copyPA()
    {
    	String pa =pickup_searchBox.getText();
    	
    
     tripsummarycontroller td = tripsummarycontroller.getInstance();
     td.setTextPA(pa);
    }
    
    @FXML
    private void copyDA()
    {
    	String da =drop_searchBox.getText();
    	
    
     tripsummarycontroller td = tripsummarycontroller.getInstance();
     td.setTextDA(da);
    }
    
    @FXML
    private void copyTD()
    {
    	String trpd =trip_date.getText();
    	
    
     tripsummarycontroller td = tripsummarycontroller.getInstance();
     td.setTextSD(trpd);
    }*/
    
    @FXML
    private void pickuphandleSearchAction() {
        // This method will be called when the user presses Enter in the searchBox.
        String searchQuery = pickup_searchBox.getText();  
        //System.out.println(searchQuery);
        // Perform the search action...
        engine.load("https://www.google.com/maps?q=" + searchQuery);
    }	
    
    
    @FXML
    private void drophandleSearchAction() {
        // This method will be called when the user presses Enter in the searchBox.
        String searchQuery = drop_searchBox.getText();       
        // Perform the search action...
        engine.load("https://www.google.com/maps?q=" + searchQuery);
    }	
   
    
    
    @FXML
	public void load_googlemap(ActionEvent event)
	{
	   
			String apiKey = "YOUR_API_KEY";
			 String htmlContent ="<!DOCTYPE html>" + "<html lang='en'>" + "<head>"
		                + "    <meta charset='UTF-8'>" + "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>"
		                + "    <title>Google Map with Search</title>"
		                + "    <script src='https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap' async defer></script>"
		                + "    <style>" + "        #map {" + "            height: 400px;"
		                + "            width: 100%;" + "        }" + "    </style>" + "</head>" + "<body>"
		                + "    <div id='search-box'>"
		                + "        <input id='pac-input' type='text' placeholder='Search Box' style='width: 300px;'>"
		                + "    </div>" + "    <div id='map'></div>" + "    <script>"
		                + "        function initMap() {"
		                + "            var myLatLng = { lat: -34.397, lng: 150.644 };"
		                + "            var map = new google.maps.Map(document.getElementById('map'), {"
		                + "                center: myLatLng," + "                zoom: 8" + "            });"
		                + "            var marker = new google.maps.Marker({"
		                + "                position: myLatLng," + "                map: map,"
		                + "                title: 'Marker Title'" + "            });"
		                + "            var searchBox = new google.maps.places.SearchBox(document.getElementById('pac-input'));"
		                + "            map.controls[google.maps.ControlPosition.TOP_LEFT].push(document.getElementById('pac-input'));"
		                + "            map.addListener('bounds_changed', function() {"
		                + "                searchBox.setBounds(map.getBounds());" + "            });"
		                + "            searchBox.addListener('places_changed', function() {"
		                + "                var places = searchBox.getPlaces();"
		                + "                if (places.length === 0) {" + "                    return;"
		                + "                }" + "                var bounds = new google.maps.LatLngBounds();"
		                + "                places.forEach(function(place) {"
		                + "                    bounds.extend(place.geometry.location);" + "                });"
		                + "                map.fitBounds(bounds);" + "            });" + "        }" + "    </script>"
		                + "</body>" + "</html>";
			 
			 try
			 {
				 File htmlFile = new File("google_map.html");
		         FileWriter fileWriter = new FileWriter(htmlFile);
		         fileWriter.write(htmlContent);
		         fileWriter.close();
		         
		         engine.load(htmlFile.toURI().toString());
		         
		         
		         
			 }
			 catch (IOException e) {
		            e.printStackTrace();
		        }
		
			 
			 

	}
    public void view_calendar() {
	    datebtn.setOnAction(eventaction -> {
	        try {
	            // Set the default date to today
	            datePicker.setValue(java.time.LocalDate.now());

	            // Create a new Stage for the calendar
	            Stage calendarStage = new Stage();
	            calendarStage.setTitle("Calendar");

	            // Create a VBox to hold the DatePicker
	            VBox vBox = new VBox(datePicker);

	            // Set the scene for the calendar Stage
	            Scene calendarScene = new Scene(vBox, 300, 200);
	            calendarStage.setScene(calendarScene);

	            // Show the calendar Stage
	            calendarStage.show();

	            // Update the date TextField when a date is selected
	            datePicker.setOnAction(e -> {
	                java.time.LocalDate selectedDate = datePicker.getValue();
	                trip_date.setText(selectedDate.toString());
	                
	            });
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	}
   
   public void view_time() {
	    timebtn.setOnAction(eventaction -> {
	        try {
	        	

	             int selectedHour = hour_spinner.getValue();
	             int selectedMinute = min_spinner.getValue();

	             String formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
	             trip_time.setText(formattedTime);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	}
    
   
   public void search_trip()
   {
	   String sql = "SELECT * FROM offerride WHERE pickup_location = ? and drop_location = ? and Date = ? and Time = ?";
   	   connect = database.connectDb();
   	
   	try {
   		prepare = connect.prepareStatement(sql);
   		prepare.setString(1, pickup_searchBox.getText());
   		prepare.setString(2, drop_searchBox.getText());
   		prepare.setString(3, trip_date.getText());
   		prepare.setString(4, trip_time.getText());
   		
   		result = prepare.executeQuery();
   		
   		Alert alert;
   		
   		if(pickup_searchBox.getText().isEmpty() || drop_searchBox.getText().isEmpty() || trip_date.getText().isEmpty() || trip_time.getText().isEmpty() )
   		{
   			alert = new Alert(AlertType.ERROR);
   			alert.setHeaderText(null);
   			alert.setContentText("Please fill all blank fields");
   			alert.showAndWait();
   		}
   		
   		else
   		{
   			if(result.next())
   			{
   				try {
   					
   					Parent root = FXMLLoader.load(getClass().getResource("tripsummary.fxml"));
   		 			Stage stage = new Stage();
   		 			Scene scene = new Scene(root);
   		 			stage.setTitle("Trip summary");
   		 			
   		 			stage.setScene(scene);
   		 			stage.show();
   		 			
   		 			String PA = result.getString("pickup_location");
   		 			String DA = result.getString("drop_location");
   		 			String TD = result.getString("Date");
   		 			String TT = result.getString("Time");
   		 			String ED = result.getString("Distance");
   		 			String ET = result.getString("traveltime");
   		 			String Price = result.getString("Price");
   		 			tripsummarycontroller td = tripsummarycontroller.getInstance();
   		 			td.setTextPA(PA);
   		 			td.setTextDA(DA);
             		td.setTextSD(TD);
             		td.setTextST(TT);
             		td.setTextPPS(Price);
             		td.setTextED(ED);
             		td.setTextET(ET);
             		car_dets();
             		driver_name();
             		driver_contact();
             		
   				}
   				catch (Exception e)
   			   	{
   			   		e.printStackTrace();
   			   	}
   				
             
             
             /*System.out.println(PA);
             System.out.println(DA);
             System.out.println(TD);
             System.out.println(TT);
             System.out.println(ED);
             System.out.println(ET);
             System.out.println(Price);*/
             
   			}
   			else
   			{
   				alert = new Alert(AlertType.ERROR);
   				alert.setHeaderText(null);
       			alert.setContentText("Sorry, No Trips found for the specified locations");
       			alert.showAndWait();
   			}
   		}
   		
   			
   		
   	}
   	catch (Exception e)
   	{
   		e.printStackTrace();
   	}
   }
   
   public void car_dets() {
	    String sql = "SELECT * FROM cardetails ORDER BY carnumber DESC LIMIT 1";
	    connect = database.connectDb();
	    try {
	        prepare = connect.prepareStatement(sql);
	        result = prepare.executeQuery();
	        
	        // Check if there is at least one row in the result set
	        if (result.next()) {
	            String CN = result.getString("CarName");
	            String Cno = result.getString("carnumber");
	            tripsummarycontroller td = tripsummarycontroller.getInstance();
	            td.setTextcarname(CN);
	            td.setTextcarno(Cno);
	        } else {
	            // Handle the case when there are no rows in the result set
	            System.out.println("No data found in cardetails table.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
   
   
   public void driver_name() {
	    String sql = "SELECT * FROM driver ORDER BY firstname DESC LIMIT 1";
	    connect = database.connectDb();
	    try {
	        prepare = connect.prepareStatement(sql);
	        result = prepare.executeQuery();
	        
	        // Check if there is at least one row in the result set
	        if (result.next()) {
	            String name = result.getString("firstname");
	            //String Cno = result.getString("carnumber");
	            tripsummarycontroller td = tripsummarycontroller.getInstance();
	            td.setTextdrivername(name);
	            //td.setTextcarno(Cno);
	        } else {
	            // Handle the case when there are no rows in the result set
	            System.out.println("No data found in cardetails table.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
   
   public void driver_contact() {
	    String sql = "SELECT * FROM driverdetails ORDER BY drivercontact DESC LIMIT 1";
	    connect = database.connectDb();
	    try {
	        prepare = connect.prepareStatement(sql);
	        result = prepare.executeQuery();
	        
	        // Check if there is at least one row in the result set
	        if (result.next()) {
	            String no = result.getString("drivercontact");
	            //String Cno = result.getString("carnumber");
	            tripsummarycontroller td = tripsummarycontroller.getInstance();
	            td.setTextdrivercontact(no);
	            //td.setTextcarno(Cno);
	        } else {
	            // Handle the case when there are no rows in the result set
	            System.out.println("No data found in cardetails table.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
  
   
   
   

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		engine = webView.getEngine();
		
	}
	
}


