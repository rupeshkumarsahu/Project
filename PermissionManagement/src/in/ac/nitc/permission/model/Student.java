package in.ac.nitc.permission.model;

public class Student extends User{
	
	private String rollno;
	private int studentId;
	
	
	public Student(){
	}
	@Override
	public void setUserDetails(String email,String password) {
		
	}
	public Student(int userId, String name, String password, String email, String mobile, String dept, int type,
			String rollno, int studentId) {
		super(userId, name, password, email, mobile, dept, type);
		this.rollno = rollno;
		this.studentId = studentId;
	}
	@Override
	public void viewRaisedPermission() {
		
	}
	public boolean raisePermission(Permission p)
	{
	  Permission p12 = new Permission();
	  return p12.insertPermissionData(p);
	}
	
	
	

	
}