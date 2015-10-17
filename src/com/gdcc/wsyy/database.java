package com.gdcc.wsyy;

import android.app.Activity;
import android.os.Bundle;

public class database extends Activity{
	private MyDatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		dbHelper = new MyDatabaseHelper(this,"doctor.db",null, 2);
		dbHelper.getWritableDatabase();
	}

}
