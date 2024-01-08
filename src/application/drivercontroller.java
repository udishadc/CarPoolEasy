package application; 
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
 
public class drivercontroller implements Initializable {
 
 
	 	@FXML
	    private TextField carcolor;

	    @FXML
	    private TextField carname;

	    @FXML
	    private Button driverdetails;

	    @FXML
	    private TextField drivernumber;

	    @FXML
	    private TextField modelname;

	    @FXML
	    private TextField modelyear;

	    @FXML
	    private Button no;

	    @FXML
	    private TextField owneremail;

	    @FXML
	    private TextField ownername;

	    @FXML
	    private TextField seatnumber;

	    @FXML
	    private Button yes;
	    
	    @FXML
	    private TextField driver_contact;
	    
	    @FXML
	    private Button cancel;

	    @FXML
	    public void navigateToCarOwner() {
	  yes.setOnAction(eventaction -> {
   try {
        // Assuming 'm' is an instance of Main class with a method 'changeScene'
          //m.changeScene("carowner.fxml");
	   Parent root = FXMLLoader.load(getClass().getResource("carowner.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setTitle("Car Owner details");
		
		stage.setScene(scene);
		stage.show();
     } catch (Exception e) {
          e.printStackTrace();
    }
  });
  }
   
    	
    
    		
	    
    	public void submitdriverDetails() {
        	
    	    
        	try (Connection conn = database.connectDb();
                    //PreparedStatement pstmt = conn.prepareStatement ("INSERT INTO driverdetails (DriverLicense, OwnerName, OwnerEmail, CarName, ModelName, CarColor, Modelyear, SeatNumber, drivercontact) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?")){
        		   PreparedStatement pstmt = conn.prepareStatement ("INSERT INTO driverdetails (DriverLicense,OwnerName,OwnerEmail,CarName,ModelName,CarColor,Modelyear,SeatNumber,drivercontact) VALUES (?,?,?,?,?,?,?,?,?)")){
                   pstmt.setString(1, drivernumber.getText());
                   pstmt.setString(2, ownername.getText());
                   pstmt.setString(3, owneremail.getText());
                   pstmt.setString(4, carname.getText());
                   pstmt.setString(5, modelname.getText());
                   pstmt.setString(6, carcolor.getText());
                   pstmt.setString(7, modelyear.getText());
                   pstmt.setString(8, seatnumber.getText());               
                   pstmt.setString(9, driver_contact.getText());           
                   pstmt.executeUpdate();
               } catch (SQLException e) {
                   e.printStackTrace(); // Handle exceptions appropriately
               }
        }

   
    public void driverDetails() {
    	driverdetails.setOnAction(eventaction -> {
            try {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Alert Message");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully registered");                 
                alert.showAndWait().ifPresent(response -> {             
                    if (response == ButtonType.OK) {                 
                        submitdriverDetails();
                        try {       
                        	
                        	  //m.changeScene("main.fxml");
                        	Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
  			    			Stage stage = new Stage();
  			    			Scene scene = new Scene(root);
  			    			stage.setTitle("CarPoolEasy");  			    			
  			    			stage.setScene(scene);
  			    			stage.show();
                           
                        	  String email = fetchLatestUserEmail();
                        	  //EmailSender.sendEmailToregistereduser(email);
                        	  RegisteredUserEmailSender registereduseremailSender = new RegisteredUserEmailSender();
                        	  registereduseremailSender .send(email);
                       	      String owneremail =fetchLatestOwnerEmail();
                    	      //EmailSender.Carowner(owneremail);
                       	      CarOwnerEmailSender carowneremailSender = new CarOwnerEmailSender();
                     	      carowneremailSender .send(email);
                            
                              
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
 
    try (Connection conn = database.connectDb();
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

public String fetchLatestOwnerEmail() {
    String email = null;
    String sql = "SELECT OwnerEmail FROM carpool.driverdetails ORDER BY OwnerEmail DESC LIMIT 1";
 
    try (Connection conn = database.connectDb();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            email = rs.getString("OwnerEmail");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle exceptions appropriately
    }
    
    return email;
}

public void cancel()
{
	      	
	   cancel.setOnAction(eventaction -> {
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