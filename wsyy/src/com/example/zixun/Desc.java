package com.example.zixun;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import baidu.api.HealApi;

import com.gdcc.wsyy.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

public class Desc extends Activity {
	
	private TextView one,two,three,four;
	private String description,img,level;
	ImageView imageV;
	
	private String st;
	
	 Handler han3= new Handler(){
		 public void handleMessage(android.os.Message msg) {   	   
	    	   JSONObject jsonObject;
			try {
				jsonObject = new JSONObject((String)msg.obj);
				
				description = jsonObject.getString("description");  
				img= jsonObject.getString("img");  
				level= jsonObject.getString("title");  				
			} catch (JSONException e) {			
				e.printStackTrace();
			}  
	         two.setText(level);
	         four.setText(description);
	         
	   //      HealApi.setimg(imageV, "http://tnfs.tngou.net/img"+img);
	         
	         
			
				
				
			}
	    };
	
	
	
     @Override
  protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.desc);
	imageV=(ImageView) findViewById(R.id.imageView1);
	one=(TextView) findViewById(R.id.textView1);
	two=(TextView) findViewById(R.id.textView2);
	three=(TextView) findViewById(R.id.textView3);
	four=(TextView) findViewById(R.id.textView4);
	String id_desc=getIntent().getStringExtra("ID_desc");
	final String httpUrl = "http://apis.baidu.com/tngou/ask/show";
	final String httpArg = "id="+id_desc;
	
	
	
	Thread des=new Thread(){
		
		@Override
		public void run(){
			
			
			st=HealApi.request(httpUrl, httpArg);
			
			Message msg=han3.obtainMessage();
		    msg.obj=st;
			han3.sendMessage(msg);
			
		}
		
	};
	       des.start();	
	
	
               }
	

}
