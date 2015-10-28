package com.example.zixun;

public class Model {

	
	
	private String description;
	private String title;
	private String keywords;
	private  String img;
	private String id;
	
	
	public Model(String description,String title,String keywords,String img,String id){
		setDescription(description);
		setTitle(title);
		setImg(img);
		setKeywords(keywords);
		setId(id);	
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
