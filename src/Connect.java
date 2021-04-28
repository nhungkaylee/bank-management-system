import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;  

public class Connect{
	Connection con;
	Statement statement;
    public Connect() throws ClassNotFoundException, SQLException{          

    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    	String connectionUrl = "jdbc:sqlserver://DESKTOP-I4B3JMF;database=Bank Management System;integratedSecurity=true;"  ;
    	con = DriverManager.getConnection(connectionUrl);
    	statement = con.createStatement();
//    	JOptionPane.showMessageDialog(null, "Connected"); 
        
    }  
}