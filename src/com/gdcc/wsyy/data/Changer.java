package com.gdcc.wsyy.data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Changer {
	
	    String aa;
	
	
	public String  Changerr(String china) throws UnsupportedEncodingException{
		
		
		String eStr = URLEncoder.encode(china,"utf-8");
			
		return eStr;
	}
	
	

}
