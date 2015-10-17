package org.yixing.entity;
/**
 * 
 * @author jerry
 * @Date 2012-12-6
 * @Email 1457049206@qq.com
 *  µÃÂ¿‡ User
 */
public class User {
	private int id;
	private String username;
	private String password;
	private String phoneNumber;
	
	public User() {
		super();
	}

	public User(int id, String username, String password, String phoneNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
