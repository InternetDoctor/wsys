package wsyyweb.cyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wsyyweb.login.act.url.UrlChanger;

public class cxyy extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 System.out.println("---do get----");
         this.doPost(request, response);
    
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		//  response.setContentType("text/html");
		  request.setCharacterEncoding("utf-8");
		  String yy=request.getParameter("yyname");
		   yy=new String(yy.getBytes("ISO8859-1"),"gb2312");
			//String httpUrl = "http://apis.baidu.com/tngou/hospital/name";
			//String httpArg = "name="+eStr;
			//System.out.println(eStr);
			//String xml= UrlChanger.request(httpUrl, httpArg);
			//System.out.println(eStr);
		    
		     System.out.println(yy);
			//String oo=URLDecoder.decode(yy, "utf-8");
			
			String httpUrl = "http://apis.baidu.com/tngou/hospital/name";
			String httpArg = "name="+yy;
		

			    BufferedReader reader = null;
			    String result = null;
			    StringBuffer sbf = new StringBuffer();
			    httpUrl = httpUrl + "?" + httpArg;

			    try {
			        URL url = new URL(httpUrl);
			        HttpURLConnection connection = (HttpURLConnection) url
			                .openConnection();
			        connection.setRequestMethod("GET");
			        // ����apikey��HTTP header
			        connection.setRequestProperty("apikey",  "3e1bab0d0003dde7f2f4383191a7993a");
			        connection.connect();
			        InputStream is = connection.getInputStream();
			        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			        String strRead = null;
			        while ((strRead = reader.readLine()) != null) {
			            sbf.append(strRead);
			            sbf.append("\r\n");
			        }
			        reader.close();
			        result = sbf.toString();
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			
			System.out.println(result);
			
			
				
		   
	}


}
