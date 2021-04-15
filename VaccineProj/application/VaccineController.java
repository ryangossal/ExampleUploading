package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VaccineController implements Initializable{

	 @FXML
	    private TextField nametextfield;

	    @FXML
	    private TextField vaccinetextfield;
	    
	    @FXML
	    private Button okbtn;

	    @FXML
	    void OnOkBtn(ActionEvent event) {
	    	Connection con=null;
			Statement stmt=null;
			
			
			try 
			{
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				String db = "C:\\Users\\ryang\\OneDrive\\Documents\\ComputerSc\\VaccineDB.accdb";
				String myPath = "jdbc:ucanaccess://"+db;
				
				con=DriverManager.getConnection(myPath);
				
				stmt=con.createStatement();
				
				String name = nametextfield.getText();
				String vaccine = vaccinetextfield.getText();
				
				String query = "INSERT INTO Vaccine(Name, Vaccine) VALUES('"+name+"','"+vaccine+"')";
				
				stmt.executeUpdate(query);

			} 
			

			catch (ClassNotFoundException e)
			{
				System.out.println("Problem Loading Driver");
				e.printStackTrace();
			}
			
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally 
			{
				try 
				{
					con.close();
					stmt.close();
					
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
			nametextfield.clear();
			vaccinetextfield.clear();
			
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			
			
		}

}
