package com.gdcc.wsyy;

import cn.jpush.android.api.JPushInterface;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

public class Welcome_stast extends Activity {
	 public static boolean isForeground = false;
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
				//ʵ����ת
//				startActivity(new Intent(getApplicationContext(),MainActivity.class));
				startActivity(new Intent(getApplicationContext(),login.class));
				finish();
				
				return false;
			}
		}).sendEmptyMessageDelayed(0, 2000);
		
		 AppicationPush ap=(AppicationPush)getApplication();
         ap.dosomething();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		JPushInterface.onResume(getApplication());
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		JPushInterface.onPause(getApplication());
		super.onPause();
	}
	
	
}
