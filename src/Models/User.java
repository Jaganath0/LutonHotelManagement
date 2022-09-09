package Models;

public class User {
	private int userId;
	private String name;
	private String address;
	private String email;
	private String mobile;
	private String password;
	private String company;
	private String pan;
	
	
	

	public User() {
		this.userId = 0;
		this.name = "";
		this.address = "";
	}
	
	public User(int id, String name, String address) {
		this.userId = id;
		this.name = name;
		this.address = address;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	public String toString() {
		return "User ID: "+this.userId + " Name: "+this.name+" Address: "+this.address;
	}
}
