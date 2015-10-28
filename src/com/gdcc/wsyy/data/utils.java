package com.gdcc.wsyy.data;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.R.integer;

public class utils {
	
	public static String getTextFromStream(InputStream is){
		
		byte[] b=new byte[1024] ;
		int len=0;
		
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		
		try {
			while ((len=is.read(b))!=-1) {
				bos.write(b,0,len);
				
			}
			
		String text=new String(bos.toByteArray());	
		bos.close();
		return text;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
		
		
		
	}
	
	
	

}
