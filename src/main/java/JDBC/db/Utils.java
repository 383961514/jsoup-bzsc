package JDBC.db;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ConnectionImpl;

import JDBC.connect.ConnectImpl;

public class Utils {
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		
		ConnectImpl conn = new ConnectImpl();
		return conn.getConnection();
	}
		
}
