package com.gdcc.wsyy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.gdcc.wsyy.data.utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class YyUI extends Activity {
	private  TextView ymm;
	private  TextView ydd;
	private  TextView yzz;
	private  TextView ypp;
	private  TextView yqq;
	private  String name;	
	private String address;
	private String level;
	private String message;
	private String tel;
	private String url;
	private String bb;
	private  String text;
	
	
	 Handler han1= new Handler(){
	       public void handleMessage(android.os.Message msg) {   	   
	    	   JSONObject jsonObject;
			try {
				jsonObject = new JSONObject((String)msg.obj);
				name = jsonObject.getString("name");  
				address= jsonObject.getString("address");  
				level= jsonObject.getString("level");  
				message= jsonObject.getString("message");  
				tel= jsonObject.getString("tel");  
				url= jsonObject.getString("url");  
				//Toast.makeText(YyUI.this,(String)msg.obj,Toast.LENGTH_LONG).show();
				System.out.println((String)msg.obj);
				ydd.setText(name);
				ypp.setText(address);
				yzz.setText(level);
				ymm.setText(tel);
				
				yqq.setText(message);
				
			} catch (JSONException e) {			
				e.printStackTrace();
			}  
	          
			
				
				
			}
	    };	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yyjm);
		
		 bb=getIntent().getStringExtra("yname");	
	
		 ydd=(TextView)findViewById(R.id.ym);
		 yzz=(TextView)findViewById(R.id.yd);
		 ypp=(TextView)findViewById(R.id.yz);
		 ymm=(TextView)findViewById(R.id.yp);  
		 yqq=(TextView)findViewById(R.id.yq); 

	
		
		
		Thread th=new Thread(){
			
								@Override
								public void run() {
			
										String path="http://pc-201502130051:8080/wsyyweb/servlet/cxyy";
									
										HttpClient hc=new DefaultHttpClient();
										HttpPost hp=new HttpPost(path);
										
										BasicNameValuePair nam=new BasicNameValuePair("yyname", bb);
										List<BasicNameValuePair> parameters=new ArrayList<BasicNameValuePair>();
										parameters.add(nam);
			
								     try {
									    	 
									    UrlEncodedFormEntity entity=new	 UrlEncodedFormEntity(parameters,"utf-8" );
									    	hp.setEntity(entity); 
									    	 
											HttpResponse hr=hc.execute(hp);
											if (hr.getStatusLine().getStatusCode()==200) {
												//取得实体
												HttpEntity he=hr.getEntity();
												//取得实体的输入流
											InputStream is=	he.getContent();
											
											 text=utils.getTextFromStream(is);
											//发送信息，让主线程更新UI	
			
											Message msg=han1.obtainMessage();
										    msg.obj=text;
											han1.sendMessage(msg);
							
											
											}
											
											
											
											
											
											
							
									} catch (ClientProtocolException e) {
										
											e.printStackTrace();
										} catch (IOException e) {
										
											e.printStackTrace();
									}
								
									}
								
							};
								th.start();			

	}
	
	

}
