package baidu.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class HealApi {


//
//	String httpUrl = "http://apis.baidu.com/tngou/ask/list";
//	String httpArg = "id=0&page=1&rows=20";
//	String jsonResult = request(httpUrl, httpArg);
//	System.out.println(jsonResult);

	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
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
	        // 填入apikey到HTTP header
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

	
	public static void setimg(final ImageView  img,final String picurl ) {
		new Thread(new Runnable(){

			@Override
			public void run() {
				
				try {
					HttpURLConnection conn=(HttpURLConnection) new URL(picurl).openConnection();
					conn.connect();
					InputStream is=conn.getInputStream();
					
					Bitmap bit= BitmapFactory.decodeStream(is);
					     
					
					img.setImageBitmap(bit);
					is.close();
					
					
					
					
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				
				
				
				
			}
			
			
			
			
			
			
		}).start();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

   }