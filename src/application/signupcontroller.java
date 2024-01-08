package application; 
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import javax.mail.MessagingException;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

 
public class signupcontroller implements Initializable {
 
    @FXML
    private ChoiceBox<String> Dropdown;

    @FXML
    private TextField email_id;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private Button user;
    
    @FXML
    private PasswordField password;
    
	
	//private String[] Userrole = {"Owner","Driver","Rider"};
	
	
	private List<String> Userrole = new ArrayList<>();
	
	// In your initialize method or constructor

	private static final int MAX_RETRY_ATTEMPTS = 3; // You can adjust this number
	
	
	//Database Tools
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Userrole.add("Owner");
		Userrole.add("Driver");
		Userrole.add("Rider");	
		Dropdown.getItems().addAll(Userrole);
		Dropdown.setOnAction(arg01 -> {
			try {
				Userrole(arg01);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}
	

	/*
	 * private void insertData(String fname, String lname) { String sql =
	 * "INSERT INTO carpooleasy (FirstName,LastName) VALUES (?,?)"; }
	 */

	
	/*
	 * @FXML private void handleSubmit() { String firstName = firstname.getText();
	 * String lastName = lastname.getText(); //String empId = id.getText();
	 * insertData(firstName, lastName); }
	 */

	
	
	public void Userrole(ActionEvent event) throws Exception {
		
		Main m = new Main();		
		String role = Dropdown.getValue();
		//Mylabel.setText(role);
		
		if (role == "Owner")
		{
			try {
				if(check_password())
				{
					insertuserdata();
					insertuserdatainlogin();
					Parent root = FXMLLoader.load(getClass().getResource("carowner.fxml"));
					Stage stage = new Stage();
					Scene scene = new Scene(root);
					stage.setTitle("Car Owner details");
    			
					stage.setScene(scene);
					stage.show();
				}
				else
				{
					Alert alert = new Alert(AlertType.INFORMATION);
	        		alert.setTitle("Alert Message");
	        		alert.setHeaderText(null);
	        		alert.setContentText("Password should be of the length 6 and must contain special characters");
	        		alert.showAndWait();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
		else if(role == "Driver")
		{
			try {
				if(check_password())
				{
					insertuserdata();
					insertuserdatainlogin();
					insertdriverdetails();
					Parent root = FXMLLoader.load(getClass().getResource("driver.fxml"));
					Stage stage = new Stage();
					Scene scene = new Scene(root);
					stage.setTitle("Driver details");
    			
					stage.setScene(scene);
					stage.show();
				}
				else
				{
					Alert alert = new Alert(AlertType.INFORMATION);
	        		alert.setTitle("Alert Message");
	        		alert.setHeaderText(null);
	        		alert.setContentText("Password should be of the length 6 and must contain special characters");
	        		alert.showAndWait();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
				
		//Mylabel.setText("Click on Submit!");
		user.setOnAction(eventaction -> {
            if (role == "Rider")
            {
                try {
                	//showRegistrationAlert(m);
                	showRegistrationAlert();
                	 
                		
                		
                	}
                	
					//m.changeScene("main.fxml");
				 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
		
		
	}});
		}
	
	/*public void insertuserdata()
	{
		
		String sql = "INSERT INTO signup (firstname, lastname, emailID ) VALUES (?, ?, ?)";
		connect = database.connectDb();
		String firstName = firstname.getText();
	    String lastName = lastname.getText();
	    String emailid = email_id.getText();
	    
	    try {
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1, firstName);
    		prepare.setString(2, lastName);
    		prepare.setString(3, emailid);
    		prepare.executeUpdate();
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    
	}
}*/
	
	public void insertuserdata() {
	    Task<Void> insertTask = new Task<Void>() {
	        @Override
	        protected Void call() throws SQLException {
	            String sql = "INSERT INTO signup (firstname, lastname, emailID ) VALUES (?, ?, ?)";
	            try (Connection connect = database.connectDb();
	                 PreparedStatement prepare = connect.prepareStatement(sql)) {
	                prepare.setString(1, firstname.getText());
	                prepare.setString(2, lastname.getText());
	                prepare.setString(3, email_id.getText());
	                prepare.executeUpdate();
	            }
	            return null;
	        }
	    };
	 
	    insertTask.setOnFailed(e -> {
	        Throwable problem = insertTask.getException();
	        // Handle the exception here
	    });
	 
	    new Thread(insertTask).start();
	}


	
	
	
	
	/*public void insertuserdata() {
	    Task<Void> task = new Task<Void>() {
	        @Override
	        protected Void call() throws Exception {
	            String sql = "INSERT INTO signup (firstname, lastname, emailID) VALUES (?, ?, ?)";
	            connect = database.connectDb();
	            String firstName = firstname.getText();
	            String lastName = lastname.getText();
	            String emailid = email_id.getText();
	            prepare = connect.prepareStatement(sql);
	            prepare.setString(1, firstName);
	            prepare.setString(2, lastName);
	            prepare.setString(3, emailid);
	            prepare.executeUpdate();
	            return null;
	        }
	    };
	    Thread thread = new Thread(task);
	    thread.setDaemon(true); // So it doesn't prevent the application from exiting
	    thread.start();
	}*/
	
	public void insertdriverdetails()
	{
		
		String sql = "INSERT INTO driver (firstname, lastname ) VALUES (?, ?)";
		connect = database.connectDb();
		String firstName = firstname.getText();
	    String lastName = lastname.getText();
	    //String emailid = email_id.getText();
	    
	    try {
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1, firstName);
    		prepare.setString(2, lastName);
    		//prepare.setString(3, emailid);
    		prepare.executeUpdate();
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    
	}
}
	public void insertuserdatainlogin()
	{
		
		String sql = "INSERT INTO login (email_id, password ) VALUES (?, ?)";
		connect = database.connectDb();
		String emailid = email_id.getText();
	    String pw = password.getText();
	    
	    
	    try {
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1, emailid);    		
    		prepare.setString(2, pw);
    		prepare.executeUpdate();
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    
	}
}
	
	
	private void showRegistrationAlert(){/*(Main m) throws MessagingException {
	    user.setOnAction(eventaction -> {*/
	        try {
	        	if(check_password())
	        	{
	        		Alert alert = new Alert(AlertType.INFORMATION);
	        		alert.setTitle("Alert Message");
	        		alert.setHeaderText(null);
	        		alert.setContentText("You have successfully registered. Confirmation Email has been triggered to your email address.");                 
	        		alert.showAndWait().ifPresent(response -> {             
	        			if (response == ButtonType.OK) {                 
	        				insertuserdata();
	        				insertuserdatainlogin();
	        				try {                   
	        					//m.changeScene("main.fxml");
	                       
	        					String email = email_id.getText();
	                        
	        					//EmailSender.sendEmail(email);
	        					WelcomeEmailSender welcomeSender = new WelcomeEmailSender();
	                      	    welcomeSender.send(email);
	        					sendEmailWithRetry(email, 1);
	 
	        					} catch (Exception e) {
	        						e.printStackTrace();
	        					}           
	        				}         
	        		});
	        }
	        	else
	        	{
	        		Alert alert = new Alert(AlertType.INFORMATION);
	        		alert.setTitle("Alert Message");
	        		alert.setHeaderText(null);
	        		alert.setContentText("Password should be of the length 6 and must contain special characters");
	        		alert.showAndWait();
	        	}
	        }
	        	catch (Exception e) {
	            e.printStackTrace();
	        }
	    //});
	}
	
	public boolean check_password()
	{
		String pw = password.getText();
		return pw.length() >= 6 && pw.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
		
	}
	
	private void sendEmailWithRetry(String email, int attempt) throws MessagingException {
	    if (attempt > MAX_RETRY_ATTEMPTS) {
	        // Handle max retry attempts reached
	        return;
	    }
	   // EmailSender.sendEmail(email);
		// Email sent successfully, handle success
	}
}




            

		

		
		
			//@Override
			//public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
		//}
           
		
	
			
			
	
	

			
		
			
			
			    
		
			    
		
	
	
 

 
