package com.example.zixun;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import baidu.api.HealApi;

import com.gdcc.wsyy.R;
import com.gdcc.wsyy.data.model;



public class vvv extends Activity implements OnItemClickListener {

	private ListView lv;
	private newadapter ad;
	public String zson;
	String httpUrl = "http://apis.baidu.com/tngou/ask/list";
	String httpArg = "id=0&page=1&rows=13";
	private String description;
	private String title;
	private String keywords;
	private  String img;
	private String id;
	private List<Model> mod;
	private String titleTop;
	private   TextView  ttp;
	 Handler han2= new Handler(){
	       public void handleMessage(android.os.Message msg) {   	   
	    	   JSONObject jsonObject;
			try {
				jsonObject = new JSONObject((String)msg.obj);
				
				JSONArray addrArrays = jsonObject.getJSONArray("tngou");  
	           
	            for(int i=0;i<addrArrays.length();i++){  
	               JSONObject addrJsonObj = addrArrays.getJSONObject(i); 
	               description = addrJsonObj.getString("description");  
                    title = addrJsonObj.getString("title"); 
                    keywords=addrJsonObj.getString("keywords"); 
                    img=addrJsonObj.getString("img"); 
                    id=addrJsonObj.getString("id"); 
                    
                    mod.add(new Model(description, title, keywords, img, id));
   
	            }  
		
	            
	            ad.notifyDataSetChanged();
	            

				
			} catch (JSONException e) {			
				e.printStackTrace();
			}  
	          
			
				
				
			}
	    };
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mod=new ArrayList<Model>();
		lv=(ListView) findViewById(R.id.list);
		ad=new newadapter(this,mod);
		lv.setAdapter(ad);
		lv.setOnItemClickListener(this);
		ttp=(TextView) findViewById(R.id.Topp);
		
		titleTop=getIntent().getStringExtra("title");	
		ttp.setText(titleTop);

		Thread ath=new Thread(){
			
			@Override
			public void run(){
				
				
				zson=HealApi.request(httpUrl, httpArg);
				
				Message msg=han2.obtainMessage();
			    msg.obj=zson;
				han2.sendMessage(msg);
				
			}
			
		};
		ath.start();
	}




	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
	
		 Model moo= mod.get(position);
		   
		Intent innn=new  Intent(this,Desc.class );
		innn.putExtra("ID_desc", moo.getId());
		startActivity(innn);
		
		
	}

}
