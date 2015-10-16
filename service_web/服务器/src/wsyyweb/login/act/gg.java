package wsyyweb.login.act;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class gg {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		    link gLink=new link();
		    gLink.linking();
	        gLink.sql="SELECT* FROM login WHERE userid='135'";
		     ResultSet rSet= gLink.statement.executeQuery(gLink.sql);
		     while (rSet.next()) {
					String id=rSet.getString("userid");
					String psw=rSet.getString("psw");
					
					System.out.print(id+psw);
					
				}
		    
		    gLink.statement.close();
			gLink.conn.close();
		    
	       
	    

		
		

	}

}
