package doctor;

public class User {
	private int idlogin;
	private String username;
	private String password;
	
	public User() {
		super();
	}

	public User(int idlogin, String username, String password, String phoneNumber) {
		super();
		this.idlogin = idlogin;
		this.username = username;
		this.password = password;
	
	}

	public int getIdlogin() {
		return idlogin;
	}

	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
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

	
	
	
}
