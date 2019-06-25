package in.ac.nitc.permission.model;

import java.sql.Date;

public class StudentLabAdmin extends Student{
	
	private int studentLabAdminId;
	private Date dateOfStart;
	private Date dateOfEnd;
	private String status;
	public StudentLabAdmin() {
		
	}
	@Override
	public void setUserDetails(String email,String password) {
		
	}
	public StudentLabAdmin(int userId, String name, String password, String email, String mobile, String dept, int type,
			String rollno, int studentId, int studentLabAdminId, Date dateOfStart, Date dateOfEnd, String status) {
		super(userId, name, password, email, mobile, dept, type, rollno, studentId);
		this.studentLabAdminId = studentLabAdminId;
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
		this.status = status;
	}
	public boolean acceptForPresence() {
		return true;
	}
}
