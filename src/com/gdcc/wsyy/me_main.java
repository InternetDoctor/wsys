package com.gdcc.wsyy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class me_main extends Fragment {

      private  Button  bb1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		
		View view = inflater.inflate(R.layout.me_main, container, false);  
        bb1 = (Button) view.findViewById(R.id.denglu2);  
        bb1.setOnClickListener(new OnClickListener()  
        {  
            @Override  
            public void onClick(View v)  
            {  
            	
         Intent ll=new Intent(getActivity(),login.class);
         startActivity(ll);
            	
            	
            }  
        });  
		
		
		
		
		
		return view;
		
	}
	
	
 
	
}
