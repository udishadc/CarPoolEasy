package application;
 
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.sql.ResultSet;
 
 
public class carownercontroller implements Initializable {
 
    @FXML
    private TextField license;
    @FXML
    private TextField car;
    @FXML
    private TextField model;
    @FXML
    private TextField year;
    @FXML
    private TextField color;
    @FXML
    private TextField seats;
    @FXML
    private TextField ssn;
    @FXML
    private Button cardetails;
    @FXML
    private TextField car_no;
    @FXML
    private Button cancelbtn;
    
    
    
    
   private Connection connect;
   private PreparedStatement prepare;
   private ResultSet result;
  
    public void submitCarDetails() {
    	
  
        try (Connection connect = database.connectDb();
        	PreparedStatement pstmt = connect.prepareStatement("INSERT INTO cardetails (SSN, LicenseNumber, CarName, ModelNumber, ModelYear, Color, Seats, carnumber) VALUES (?, ?, ?, ?, ?, ?, ?,?)")) {
            pstmt.setString(1, ssn.getText());
            pstmt.setString(2, license.getText());
            pstmt.setString(3, car.getText());
            pstmt.setString(4, model.getText());
            pstmt.setString(5, year.getText());
            pstmt.setString(6, color.getText());
            pstmt.setString(7, seats.getText());
            pstmt.setString(8, car_no.getText());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }
 
    public void cardetails()
    {
    	cardetails.setOnAction(eventaction -> {
            try {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Alert Message");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully registered. Confirmation Email has been triggered to your email address.");                 
                alert.showAndWait().ifPresent(response -> {             
                    if (response == ButtonType.OK) {                 
                        submitCarDetails();
                        try {       
                        	
                        	
 
                        	  String email = fetchLatestUserEmail();
                        	  //EmailSender.sendEmailToregistereduser(email);
                        	  CarOwnerEmailSender carowneremailSender = new CarOwnerEmailSender();
                        	  carowneremailSender .send(email);
                        	  
                            
                        	  //m.changeScene("main.fxml");
                        	Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
  			    			Stage stage = new Stage();
  			    			Scene scene = new Scene(root);
  			    			stage.setTitle("CarPoolEasy");
  			    			
  			    			stage.setScene(scene);
  			    			stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }           
                    }         
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
 
 
public String fetchLatestUserEmail() {
    String email = null;
    String sql = "SELECT emailID FROM carpool.signup ORDER BY emailID DESC LIMIT 1";
 
    try (Connection conn =  connect = database.connectDb();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            email = rs.getString("emailID");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle exceptions appropriately
    }
    
    return email;
}

public void cancel()
{
	      	
	   cancelbtn.setOnAction(eventaction -> {
	    		try {
	    			Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
	    			Stage stage = new Stage();
	    			Scene scene = new Scene(root);
	    			stage.setTitle("Sign Up");
	    			
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
 



