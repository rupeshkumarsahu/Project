package in.ac.nitc.permission.model;

import java.sql.Date;

public class User {
	protected int userId;
	protected String name;
	private String password;
	protected String email;
	protected String mobile;
	protected String dept;
	protected int type;
	public User() {
		
	}
	public void setUserDetails(String email,String password) {
		
	}
	public User(int userId, String name, String password, String email, String mobile, String dept, int type) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.dept = dept;
		this.type = type;
	}
	public void viewRaisedPermission() {
		
	}
}

