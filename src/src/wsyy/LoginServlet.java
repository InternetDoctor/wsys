package wsyy;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("GBK");
		String uName=request.getParameter("n");
	    String uPass=request.getParameter("m");
	    UserBiz userBiz=new UserBizlmpl();
	    User user=userBiz.findUser(uName);
	    if(user!=null&&user.getuPass().equals(uPass)){
	    	HttpSession session=request.getSession(true);
	       session.setAttribute("user", user);
	    	 	}
	    response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();

	}

}
