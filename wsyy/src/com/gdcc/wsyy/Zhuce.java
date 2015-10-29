package com.gdcc.wsyy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Zhuce extends Activity {
	
	
	
	private Button  bb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		bb=(Button) findViewById(R.id.Register);
		bb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v2) {
				Toast.makeText(Zhuce.this,"恭喜你注册成功", 0).show();
				
			finish();
				
				
			}
				
			
		});
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
