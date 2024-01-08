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


public class offerridecontroller implements Initializable{


    @FXML
    private TextField trip_date;

    

    @FXML
    private TextField number_seats;

   

    @FXML
    private TextField price_per_seat;

    @FXML
    private Button publishbtn;

    @FXML
    private TextField trip_time;
    
    @FXML
    private Button timebtn;
    
    @FXML
    private Button datebtn;
    
    @FXML
    private Spinner<Integer> hour_spinner;

    @FXML
    private Spinner<Integer> min_spinner;
    
    @FXML
    private TextField drop_searchBox;
    
    @FXML
    private Button load_map;
    
    @FXML
    private TextField pickup_searchBox;
    
    @FXML
    private WebView webView;
    
    private WebEngine engine;
    
    DatePicker datePicker = new DatePicker();
   
    //Database tools
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    @FXML
    private void copyPA()
    {
    	String pa =pickup_searchBox.getText();
    	
    
     tripdetails td = tripdetails.getInstance();
     td.setTextPA(pa);
    }
    
    @FXML
    private void copyDA()
    {
    	String da =drop_searchBox.getText();
    	
    
     tripdetails td = tripdetails.getInstance();
     td.setTextDA(da);
    }
    
    @FXML
    private void copyTD()
    {
    	String trpd =trip_date.getText();
    	
    
     tripdetails td = tripdetails.getInstance();
     td.setTextSD(trpd);
    }
    
    @FXML
    private void copyTT()
    {
    	String trpt =trip_time.getText();
    	
    
     tripdetails td = tripdetails.getInstance();
     td.setTextST(trpt);
    }
    
    @FXML
    private void copyNS()
    {
    	String ns =number_seats.getText();
    	
    
     tripdetails td = tripdetails.getInstance();
     td.setTextSeats(ns);
    }
    
    @FXML
    private void copyPPS()
    {
    	String pps =price_per_seat.getText();
    	
    
     tripdetails td = tripdetails.getInstance();
     td.setTextPPS(pps);
    }
    
    @FXML
    private void copyET()
    {
    	String p_address = pickup_searchBox.getText();
	    String d_address = drop_searchBox.getText();
	    DistanceAndTime result = getDrivingDistanceAndTime(p_address, d_address);	    
    	String et =String.valueOf(result.getTime());
    	
    	
    
     tripdetails td = tripdetails.getInstance();
     td.setTextET(et);
    }
    
    @FXML
    private void copyED()
    {
    	String p_address = pickup_searchBox.getText();
	    String d_address = drop_searchBox.getText();
	    DistanceAndTime result = getDrivingDistanceAndTime(p_address, d_address);	    
    	String ed =String.valueOf(result.getDistance());
    	
    	
    
     tripdetails td = tripdetails.getInstance();
     td.setTextED(ed);
    }
    
    
    
    
    
    private static final String GOOGLE_MAPS_API_KEY = "YOUR_API_KEY";
    //private static final String GOOGLE_MAPS_URL = "https://maps.google.com";
    
  
    public void publish_ride()
	   {
		      	
		   publishbtn.setOnAction(eventaction -> {
		    		try {
		    			Parent root = FXMLLoader.load(getClass().getResource("tripdetails.fxml"));
		    			Stage stage = new Stage();
		    			Scene scene = new Scene(root);
		    			stage.setTitle("Trip details");
		    			
		    			stage.setScene(scene);
		    			stage.show();
		    			insert_offerride_data();
		    			copyPA();
		    			copyDA();
		    			copyTD();
		    			copyTT();
		    			copyNS();
		    			copyPPS();
		    			copyET();
		    			copyED();
		    			
		    			//get_distance();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	});
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
	    
	   
		/*
		 * public void autocomplete_drop_location() {
		 * drop_location.setOnMouseClicked(event -> { // Load the Google Maps Places
		 * Autocomplete widget when the TextField is clicked WebEngine webEngine =
		 * web_view.getEngine();
		 * webEngine.load(getClass().getResource("index.html").toString());
		 * 
		 * // Set the API key and text field ID in the JavaScript code
		 * webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue,
		 * newValue) -> { if (newValue == Worker.State.SUCCEEDED) {
		 * webEngine.executeScript("initAutocomplete('" + GOOGLE_MAPS_API_KEY +
		 * "', 'drop_location');"); } });
		 * 
		 * // Create a new Stage for the WebView Stage autocompleteStage = new Stage();
		 * autocompleteStage.setTitle("Google Maps Autocomplete");
		 * 
		 * // Set the scene for the autocomplete Stage Scene autocompleteScene = new
		 * Scene(web_view, 600, 400); autocompleteStage.setScene(autocompleteScene);
		 * 
		 * // Show the autocomplete Stage autocompleteStage.show(); }); }
		 */
	   
	 
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
	   public void insert_offerride_data()
		{
		    String p_address = pickup_searchBox.getText();
		    String d_address = drop_searchBox.getText();
		    DistanceAndTime result = getDrivingDistanceAndTime(p_address, d_address);	
		    
			String sql = "INSERT INTO offerride (pickup_location,drop_location, Date, Time, seats, price, Distance, traveltime) VALUES (?,?,?,?,?,?,?,?)";
			connect = database.connectDb();
			String pickup_location = pickup_searchBox.getText();
		    String drop_location = drop_searchBox.getText();
		    String Date = trip_date.getText();
		    String Time = trip_time.getText();
		    String seats = number_seats.getText();
		    String price = price_per_seat.getText();
		    double distance = result.getDistance();
		    double travel_time = result.getTime();
		    		
		    /*if(result!= null)
		    {
		    	System.out.print(result.getDistance());
		    	System.out.print(result.getTime());
		    }*/
		    
		    
		    try {
	    		prepare = connect.prepareStatement(sql);
	    		prepare.setString(1,pickup_location);
	    		prepare.setString(2, drop_location);
	    		prepare.setString(3, Date);
	    		prepare.setString(4, Time);
	    		prepare.setString(5, seats);
	    		prepare.setString(6, price);	
	    		prepare.setDouble(7, distance);
	    		prepare.setDouble(8, travel_time);
	    		prepare.executeUpdate();
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    
		}
		}
		
		/*
		 * public void get_distance() { String p_address = pickup_searchBox.getText();
		 * String d_address = drop_searchBox.getText(); DistanceAndTime result =
		 * getDrivingDistanceAndTime(p_address, d_address); if (result != null) {
		 * System.out.println("Driving distance between the two locations: " +
		 * result.getDistance() + " miles");
		 * System.out.println("Estimated travel time: " + result.getTime() +
		 * " minutes"); }
		 * 
		 * 
		 * }
		 */
		 
	   
	   
	   
	   private static DistanceAndTime getDrivingDistanceAndTime(String origin, String destination) {
	        try {
	            // Replace "YOUR_API_KEY" with your actual Google Maps Directions API key
	            String apiKey = "YOUR_API_KEY";

	            // Create the URL for the Directions API request
	            String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
	                    + origin.replaceAll(" ", "+") + "&destination=" + destination.replaceAll(" ", "+")
	                    + "&mode=driving&key=" + apiKey;

	            // Make the HTTP request
	            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	            connection.setRequestMethod("GET");

	            // Check for successful response code
	            int responseCode = connection.getResponseCode();
	            if (responseCode != HttpURLConnection.HTTP_OK) {
	                System.err.println("Error: " + responseCode + " " + connection.getResponseMessage());
	                return null;
	            }

	            // Read the response
	            BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            StringBuilder response = new StringBuilder();
	            String line;
	            while ((line = responseReader.readLine()) != null) {
	                response.append(line);
	            }
	            responseReader.close();

	            // Parse the JSON response using Jackson library
	            ObjectMapper objectMapper = new ObjectMapper();
	            JsonNode jsonNode = objectMapper.readTree(response.toString());

	            // Check the status in the JSON response
	            String status = jsonNode.path("status").asText();
	            if (!"OK".equals(status)) {
	                System.err.println("Error in Directions API response: " + status);
	                return null;
	            }

	            // Get the driving distance in miles
	            JsonNode legs = jsonNode.path("routes").get(0).path("legs");
	            double distance = legs.get(0).path("distance").path("value").asDouble() * 0.000621371; // Convert meters to miles

	            // Get the estimated travel time in minutes
	            int time = legs.get(0).path("duration").path("value").asInt() / 60;

	            return new DistanceAndTime(distance, time);

	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    private static class DistanceAndTime {
	        private double distance;
	        private int time;

	        public DistanceAndTime(double distance, int time) {
	            this.distance = distance;
	            this.time = time;
	        }

	        public double getDistance() {
	            return distance;
	        }

	        public int getTime() {
	            return time;
	        }
	    }		
		   		
	   
	   
	   


	
	

	    
		   
	   
	   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		engine = webView.getEngine();
		
		
		
		
		
		
	}
}


	 
	   
	   

	
	

