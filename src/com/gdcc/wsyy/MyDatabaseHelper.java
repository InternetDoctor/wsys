package com.gdcc.wsyy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
	public static final String CREATE_BOOK="create table login ("
            +"id integer primary key antoincrement,"
			+"user text,"
            +"password text)";
	private Context mContext;
	public MyDatabaseHelper(Context context,String name,CursorFactory factory,int version)
	{
		super(context,name,factory,version);
	}
	public void onCreate(SQLiteDatabase db){
		db.execSQL(CREATE_BOOK);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
     
}
