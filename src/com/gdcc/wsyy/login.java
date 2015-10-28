package com.gdcc.wsyy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class login extends Activity {
	
	
	
	ImageView loginback;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_in);
		loginback=(ImageView)findViewById(R.id.login_back);
		loginback.setOnClickListener(new OnClickListener()  
        {  
            @Override  
            public void onClick(View v)  
            {  
            	finish();
       
            	
            }  
        });  
		
		
		
		
		
		
	}
	
	
	
}
