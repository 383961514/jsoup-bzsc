package JDBC.mainMethod;

import java.sql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Util;

import JDBC.db.Utils;
import JDBC.model.StatModel;

	

	public class Method {
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			StatModel model2 = new StatModel();
			System.out.println(model2);
			insert(model2);
		}
		public static String insert(StatModel model) throws ClassNotFoundException, SQLException
		{
			Connection conn = Utils.getConn();
			java.sql.Statement stmt = conn.createStatement();
			String sql = "insert into users(sqname,oldname,usname,srcimage,imagename) values('"+model.getSqName()+"','"+model.getOldName()+
					"','"+model.getUsName()+"','"+model.getSrcImage()+"','"+model.getImageName()+"')";
			
			int rows = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			return null;
		
		}
}
