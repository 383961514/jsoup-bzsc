package JDBC.connect;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnectImpl {
	 public Connection getConnection() throws ClassNotFoundException, SQLException 
	 { 

				Class.forName("com.mysql.jdbc.Driver");
									
			     //加载MYSQL JDBC驱动程序    
	          Connection connect = (Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root","mysql");
			return connect; 
	      
	 }
	} 