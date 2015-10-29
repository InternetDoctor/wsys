package com.gdcc.wsyy;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
<<<<<<< HEAD
<<<<<<< HEAD
import java.net.URLEncoder;
import java.security.PublicKey;
=======
>>>>>>> origin/master
=======
import java.net.URLEncoder;
import java.security.PublicKey;
>>>>>>> parent of 97e08b4... 第二次提交
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of 97e08b4... 第二次提交
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.gdcc.wsyy.data.Changer;
import com.gdcc.wsyy.data.utils;
import com.gdcc.wsyy.json.Jeshijson;
import com.gdcc.wsyy.json.yyjson;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
<<<<<<< HEAD
=======
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
>>>>>>> origin/master
=======
>>>>>>> parent of 97e08b4... 第二次提交
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
<<<<<<< HEAD
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class service_main extends Fragment {
	
	
	EditText SearEdit;
	ImageView  SearchB;
	String bb;
	String yym; 
	
	
	String name;	
	String address;
	String level;
	String message;
	String tel;
	String url;
	
	
	
	
	
	
	Handler han= new Handler(){
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
			
			
		} catch (JSONException e) {			
			e.printStackTrace();
		}  
          
			Toast.makeText(getActivity(),name+address+tel+url+tel+message,Toast.LENGTH_LONG).show();
			
			
		}
    };
	
=======
=======
import android.view.View.OnClickListener;
import android.widget.Button;
>>>>>>> parent of 97e08b4... 第二次提交
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class service_main extends Fragment {
	
	
	EditText SearEdit;
	ImageView  SearchB;
	String bb;
<<<<<<< HEAD
	String yym;
	TextView FJYY, WENDA,CCSS,XLZX,JKTS;

>>>>>>> origin/master
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.service_m_main, null);
		SearchB = (ImageView) view.findViewById(R.id.iv_search);
		SearEdit = (EditText) view.findViewById(R.id.et_search);
		FJYY = (TextView) view.findViewById(R.id.fjyy);
		WENDA = (TextView) view.findViewById(R.id.newda);
		CCSS = (TextView) view.findViewById(R.id.ccss);
		XLZX = (TextView) view.findViewById(R.id.XLZX);
		JKTS = (TextView) view.findViewById(R.id.JKTS);

		WENDA.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intentnn = new Intent(getActivity(), vvv.class);
                         intentnn.putExtra("title", "最近问答");
				         startActivity(intentnn);
			}
		});
		
		CCSS.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intentcs = new Intent(getActivity(), vvv.class);
                         intentcs.putExtra("title", "健康常识");
				         startActivity(intentcs);
			}
		});
		
		XLZX.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intentX = new Intent(getActivity(), vvv.class);
                         intentX.putExtra("title", "心理咨询");
				         startActivity(intentX);
			}
		});
		
		JKTS.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intentj = new Intent(getActivity(), vvv.class);
                         intentj.putExtra("title", "健康图书");
				         startActivity(intentj);
			}
		});
		
		
<<<<<<< HEAD
	 View view=inflater.inflate(R.layout.service_m_main, null);
   	    SearchB = (ImageView) view.findViewById(R.id.iv_search);
	    SearEdit=(EditText)view.findViewById(R.id.et_search);
	  
		  
		  
		  
		 SearchB.setOnClickListener(new OnClickListener()  
	        {  
	            @Override  
	            public void onClick(View v)  
	            {  
	            	
	           	 yym=SearEdit.getText().toString();
	            	
	            	
	          
	   
	   		    Changer changer=new Changer();
	   		  try {
	   		 bb=changer.Changerr(yym);
	   		
	   		
	   		
	   		  } catch (UnsupportedEncodingException e1) {
	   		
	   			e1.printStackTrace();
	   		   }

	   		  Toast.makeText(getActivity() ,bb, Toast.LENGTH_LONG).show();
	            	
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
								
								String text=utils.getTextFromStream(is);
								//发送信息，让主线程更新UI	

								Message msg=han.obtainMessage();
								msg.obj=text;
								han.sendMessage(msg);
	
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
	        });  
		
         return view;
=======
=======
	String yym; 
	
	
	String name;	
	String address;
	String level;
	String message;
	String tel;
	String url;
	TextView FJYY;
	
	
	
	
	
	Handler han= new Handler(){
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
			
			
		} catch (JSONException e) {			
			e.printStackTrace();
		}  
          
			Toast.makeText(getActivity(),name+address+tel+url+tel+message,Toast.LENGTH_LONG).show();
			
			
		}
    };
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
>>>>>>> parent of 97e08b4... 第二次提交
		
	 View view=inflater.inflate(R.layout.service_m_main, null);
   	    SearchB = (ImageView) view.findViewById(R.id.iv_search);
	    SearEdit=(EditText)view.findViewById(R.id.et_search);
	    FJYY=(TextView)view.findViewById(R.id.fjyy);
	    
	    
	    FJYY.setOnClickListener(new OnClickListener(){
	    	 @Override  
	            public void onClick(View v) 
	    	 {
	    		  Intent intent=new Intent(getActivity(),NearbyMapActivity.class);
	    	         startActivity(intent);
	    	 }
	    }
	   );
	  
		  
		  
		  
		 SearchB.setOnClickListener(new OnClickListener()  
	        {  
	            @Override  
	            public void onClick(View v)  
	            {  
	            	
	           	 yym=SearEdit.getText().toString();
	            	
	            	
	          
	   
	   		    Changer changer=new Changer();
	   		  try {
	   		 bb=changer.Changerr(yym);
	   		
	   		
	   		
	   		  } catch (UnsupportedEncodingException e1) {
	   		
	   			e1.printStackTrace();
	   		   }

	   		  Toast.makeText(getActivity() ,bb, Toast.LENGTH_LONG).show();
	            	
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
								
								String text=utils.getTextFromStream(is);
								//发送信息，让主线程更新UI	

								Message msg=han.obtainMessage();
								msg.obj=text;
								han.sendMessage(msg);
	
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
	        });  
		
<<<<<<< HEAD
		

		// 加载地图
		FJYY.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getActivity(),
						NearbyMapActivity.class);

				startActivity(intent);

			}
		});

		SearchB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				yym = SearEdit.getText().toString();

				Changer changer = new Changer();
				try {
					bb = changer.Changerr(yym);

				} catch (UnsupportedEncodingException e1) {

					e1.printStackTrace();
				}
				Intent intentyy = new Intent(getActivity(), YyUI.class);
				intentyy.putExtra("yname", bb);
				startActivity(intentyy);

			}
		});

		return view;

>>>>>>> origin/master
=======
         return view;
>>>>>>> parent of 97e08b4... 第二次提交
	}

}
