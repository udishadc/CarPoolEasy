package application;
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

public class logincontroller implements Initializable {
	
	
	@FXML
    private TextField emailid;

    @FXML
    private Button loginbtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private Button signupbtn;
    
  
    
    
    
    //Database Tools
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void login()
    {
    	String sql = "SELECT * FROM login WHERE email_id = ? and password = ?";
    	connect = database.connectDb();
    	
    	try {
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1, emailid.getText());
    		prepare.setString(2, password.getText());
    		
    		result = prepare.executeQuery();
    		
    		Alert alert;
    		
    		if(emailid.getText().isEmpty() || password.getText().isEmpty())
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
    				alert = new Alert(AlertType.INFORMATION);
    				alert.setHeaderText(null);
        			alert.setContentText("Successfully Login!");
        			alert.showAndWait();
        			
        			//HIDE YOUR LOGIN FORM
        			loginbtn.getScene().getWindow().hide();
        			
        			//Linking the signup page 
        			
        			
        			
        			Parent root = FXMLLoader.load(getClass().getResource("maindashboard.fxml"));
        			Stage stage = new Stage();
        			Scene scene = new Scene(root);
        			stage.setTitle("Main Dashboard");
        			
        			stage.setScene(scene);
        			stage.show();
    			}
    			else
    			{
    				alert = new Alert(AlertType.ERROR);
    				alert.setHeaderText(null);
        			alert.setContentText("Wrong Username/Password");
        			alert.showAndWait();
    			}
    		}
    		
    			
    		
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
       
    public void signup()
    {
    	
    	signupbtn.setOnAction(eventaction -> {
    		try {
    			Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
    			Stage stage = new Stage();
    			Scene scene = new Scene(root);
    			stage.setTitle("sign up");    			
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
