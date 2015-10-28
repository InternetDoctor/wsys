package com.gdcc.wsyy;

import cn.jpush.android.api.JPushInterface;
import android.app.Application;
import android.util.Log;

public class AppicationPush extends Application {
	private static final String TAG = "JPush";
	
	@Override
    public void onCreate() {
    super.onCreate();
    JPushInterface.setDebugMode(true);
    JPushInterface.init(this);  
    Log.d(TAG, "[ExampleApplication] onCreate");
}

	public void dosomething() {
		System.out.println("dosomething....");
		
	}
	
	
	
}
