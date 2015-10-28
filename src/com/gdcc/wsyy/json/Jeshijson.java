package com.gdcc.wsyy.json;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Jeshijson {
	
	public List<yyjson> getyyjson( String jsonyy) {
		
		List<yyjson> clist=null;
		
		 clist  = getClist(jsonyy);
		
		
		
		
		
		return clist;
		
	}

	private List<yyjson> getClist(String jsonyy) {
		
		
		List<yyjson> clist=new ArrayList<yyjson>();
		
		try {
			JSONArray jay=new JSONArray(jsonyy);
			for (int i = 0; i < jay.length(); i++) {
				
				JSONObject temp=(JSONObject)jay.get(i);
				yyjson yy=new yyjson();
				yy.setName(temp.getString("name"));
				yy.setAddress(temp.getString("address"));
				yy.setLevel(temp.getString("level"));
				yy.setMessage(temp.getString("message"));
				yy.settel(temp.getString("tel"));
				yy.setUrl(temp.getString("url"));
				clist.add(yy);
				
				
			}
			
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return clist;
	}
	
	
	
	
	

}
