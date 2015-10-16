package wsyyweb.login.act;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class loginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	
	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                 System.out.println("---do get----");
                 this.doPost(request, response);
	}

   

	
    

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

	
		request.setCharacterEncoding("UTF-8");
		
		
		String loginName=request.getParameter("LoginName");
		String loginPassword=request.getParameter("LoginPassword");
		
		System.out.print(loginName);
		System.out.print(loginPassword);
		
		PrintWriter out=null;

	    link gLink=new link();
	    try {
			gLink.linking();
			gLink.sql="SELECT* FROM login WHERE userid='"+loginName+"'";
	     ResultSet rSet= gLink.statement.executeQuery(gLink.sql);
	     while (rSet.next()) {
				String id=rSet.getString("userid");
				String psw=rSet.getString("psw");
				
				System.out.print(id+psw);
				
				
				if (id.equals(loginName)&&psw.equals(loginPassword)) {
					System.out.print("µÇÂ½³É¹¦");
					//out.print("");
				} else {
					System.out.print("µÇÂ½Ê§°Ü");
				}
				
				
				
				
				
				
			}
	     
	     
	     
	     
	     gLink.statement.close();
		 gLink.conn.close();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
       
	     
	    
	
	    
				
       
		
	}

}
