package wsyyweb.login.act;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class link {
	
	String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3300/wsyy"; 
    String username = "root";
    String password = "";
    String sql=null;
    Connection conn=null;
    Statement statement;

	public void linking() throws ClassNotFoundException, SQLException  {
		
	    Class.forName(driver); 
	     conn =DriverManager.getConnection(url, username, password);
	     statement=conn.createStatement();
		
		
	}

}
