package com.gdcc.wsyy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdcc.wsyy.data.Biaozhi;

public class me_main extends Fragment {

	TextView bb1;
      
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.me_main, container, false);
		bb1=(TextView) view.findViewById(R.id.denglu2);
		
		bb1.setText(Biaozhi.IIDD);
		
		
		
		return view;  
	}
 
}
