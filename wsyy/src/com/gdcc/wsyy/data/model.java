package com.gdcc.wsyy.data;

public class model {
	
	private  String name;	
	private String address;
	private String level;
	private String message;
	private String tel;
	private String url;
	
	
	
	
	public  model(String name,	String address,String level,String message,String tel,String url) {
		
		setAddress(address);
		setLevel(level);
		setMessage(message);
		setName(name);
		setTel(tel);
		setUrl(url);
	}
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	

}
