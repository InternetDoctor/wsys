package wsyyweb.login.act.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlChanger {
	
	String httpUrl = "http://apis.baidu.com/tngou/hospital/name";
	String httpArg = "name=%E5%A4%8D%E6%97%A6%E5%A4%A7%E5%AD%A6%E9%99%84%E5%B1%9E%E5%8D%8E%E5%B1%B1%E5%8C%BB%E9%99%A2";
	String jsonResult = request(httpUrl, httpArg);

	public static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // ÃÓ»ÎapikeyµΩHTTP header
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
	    return result;
	}

	

}
