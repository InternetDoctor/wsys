package com.gdcc.wsyy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

public class Welcome_stast extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.welcome);
		
		
		
		
		
		
		new Handler(new Handler.Callback() {
			
			@Override
			public boolean handleMessage(Message msg) {
				//ÊµÏÖÌø×ª
				startActivity(new Intent(getApplicationContext(),MainActivity.class));
				
				
				return false;
			}
		}).sendEmptyMessageDelayed(0, 2000);
		
		
	}
	
	
}
