package com.gdcc.wsyy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class message_main extends Fragment {
	

	private Button btnStart;
	private Button btnStop;


	// private  Button  bb1;
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			
			
			View view = inflater.inflate(R.layout.message_m_main, container, false);  
	        btnStart = (Button) view.findViewById(R.id.btnStart);  
	        btnStop = (Button) view.findViewById(R.id.btnStop);  
	        btnStart.setOnClickListener(new OnClickListener()  
	        {  
	            @Override  
	            public void onClick(View v)  
	            {  
	            	
	         Intent ll=new Intent(getActivity(),message.class);
	         startActivity(ll);
	            	
	            	
	            }  
	        });  
			
			
	       /* btnStop.setOnClickListener(new OnClickListener()  
	        {  
	            @Override  
	            public void onClick(View v)  
	            {  
	            	//showDialog("用户名不能为空");
	         Intent ll=new Intent(getActivity(),message.class);
	         startActivity(ll);
	            	
	            	
	            }  
	        });  
			
			*/
			
			
			return view;
			
		}
		
		
	 
		
	}
