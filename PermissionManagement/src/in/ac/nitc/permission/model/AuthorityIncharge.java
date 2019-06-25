package in.ac.nitc.permission.model;

import java.sql.Date;

public class AuthorityIncharge extends User{
	
	private int authorityId;
	private int authLabId;
	private Date dateOfJoin;
	private Date dateOfComplete;
	private String status;
	public AuthorityIncharge() {
		
	}
	@Override
	public void setUserDetails(String email,String password) {
		
	}
	public AuthorityIncharge(int userId, String name, String password, String email, String mobile, String dept,
			int type, int authorityId, int authLabId, Date dateOfJoin, Date dateOfComplete, String status) {
		super(userId, name, password, email, mobile, dept, type);
		this.authorityId = authorityId;
		this.authLabId = authLabId;
		this.dateOfJoin = dateOfJoin;
		this.dateOfComplete = dateOfComplete;
		this.status = status;
	}
	@Override
	public void viewRaisedPermission() {
		
	}
	public void updateRaisedPermission(int id,String status,String message) {
		
		Permission p = new Permission();
		p.updateStatus(id, status,message);
	}
	public void postNotification() {
		
	}
	public void sendNotification() {
		
	}
}