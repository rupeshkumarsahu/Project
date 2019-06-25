package in.ac.nitc.permission.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import in.ac.nitc.permission.dbconnection.DBConnection;

public class Permission {
	private int event_id;
	private String start_datetime;
	private String end_datetime;
	private String purpose;
	private String student_rollno;
	private String student_name;
	private String raised_datetime;
	private String response_datetime;
	private String status;
	private String lab;
	private String message;
	private int lab_id;
	private int max_audience;
	private String dept;
	private String labName;
	
	
	public int getEventId() {
		return event_id;
	}
	public void setEventId(int event_id) {
		this.event_id = event_id;
	}
	
	public String getStartDatetime() {
		return start_datetime;
	}
	public void setStartDatetime(String start_datetime) {
		this.start_datetime = start_datetime;
	}
	
	public String getEndDatetime() {
		return end_datetime;
	}
	public void setEndDatetime(String end_datetime) {
		this.end_datetime = end_datetime;
	}
	
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	public String getStudentRollno() {
		return student_rollno;
	}
	public void setStudentRollno(String student_rollno) {
		this.student_rollno = student_rollno;
	}
	
	public String getStudentName() {
		return student_name;
	}
	public void setStudentName(String student_name) {
		this.student_name = student_name;
	}
	
	
	public String getRaisedDatetime() {
		return raised_datetime;
	}
	public void setRaisedDatetime(String raised_datetime) {
		this.raised_datetime = raised_datetime;
	}
	
	public String getResponseDatetime() {
		return response_datetime;
	}
	public void setResponseDatetime(String response_datetime) {
		this.response_datetime = response_datetime;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	
	public int getLabId() {
		return lab_id;
	}
	public void setLabId(int lab_id) {
		this.lab_id = lab_id;
	}
	
	public int getMaxAudience() {
		return max_audience;
	}
	public void setMaxAudience(int max_audience) {
		this.max_audience = max_audience;
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setMessage(String s)
	{
		this.message = s;
	}
	public String getMessage()
	{
		return message;
	}
	
	public void setLabName(String s)
	{
		this.labName=s;
	}
	public String getLabName()
	{
		if(this.lab_id==1){
			this.labName ="Network System Lab";
		}else{
			this.labName = "Software System Lab";
		}
		return this.labName;
	}
	
	@Override
	public String toString() {
		return "PermissionData [student_name=" + student_name + ", student_rollno=" + student_rollno
				+ ", dept=" + dept + ", lab_id=" + lab + ", lab_id=" + lab_id +", max_audience=" + max_audience
				+ ", start_datetime=" + start_datetime + ", end_datetime=" + end_datetime
				+ ", purpose=" + purpose + "]";
	}
	public boolean insertPermissionData(Permission pd) {
		
		try {
			DBConnection db=new DBConnection();
			Connection conn=null;
			conn=db.getDBConnection();
			
			if(conn==null) {
				throw new Exception("database connection fails");
			}else {
				System.out.println("data base connection steblished");
			}
			
			//data to insert
			String student_name=pd.getStudentName();
			String student_rollno=pd.getStudentRollno();
			String dept=pd.getDept();
			String lab=pd.getLab();
			int max_audience=pd.getMaxAudience();
			String start_datetime=pd.getStartDatetime();
			String end_datetime=pd.getEndDatetime();
			String purpose=pd.getPurpose();
			
			//getting room_number as it is unique in Lab table 
			String labRoom="";
			if(lab.equals("nsl")){
				lab="network system laboratory";
				labRoom="itl301";
			}
			else if(lab.equals("ssl")){
				lab="software system laboratory";
				labRoom="itl302";
			}
			
			String query="";

			//Part 1
			// we have to get lab_id from Lab table as lab_id is foreign 
			//key in Permission table referencing to Lab table
			
			query="select lab_id from Lab where room_number=?";
			
			PreparedStatement pst1=conn.prepareStatement(query);
			pst1.setString(1, labRoom);
			ResultSet rs=pst1.executeQuery();
			
			rs.next();
			int lab_id=rs.getInt("lab_id");
			System.out.println(lab_id);

			//Part 2
			//now insert Permission application details into permission table 
			
			query="insert into Permission(start_datetime,end_datetime,purpose,student_rollno,student_name,"
					+ "raised_datetime,max_audience,lab_id,dept) values(?,?,?,?,?,now(),?,?,?)";
			
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,start_datetime);
			pst.setString(2,end_datetime);
			pst.setString(3,purpose);
			pst.setString(4,student_rollno);
			pst.setString(5,student_name);
			pst.setInt(6,max_audience);
			pst.setInt(7,lab_id);
			pst.setString(8,dept);

			
			int count=pst.executeUpdate();
			if(count==0){
				throw new Exception("permisssion details not inserted into Permission table");
			}
			else {
				return true;
			}
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
		}
		
		return false;
	}
	public ArrayList<Permission> getObject(String choice)
	{

		//Creating a List for Storing Object which will fetch from database based on choice ie pending,declined,approved..etc
		ArrayList<Permission> list = new ArrayList<Permission>();
		DBConnection dbCon=new DBConnection();
		try{
			
			Connection connection = dbCon.getDBConnection();
			Statement statement = connection.createStatement();
			String query = "select * from Permission where status="+ "'" + choice + "'";
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()){
				Permission perm=new Permission();
				perm.setEventId(resultSet.getInt(1));
				perm.setStartDatetime(resultSet.getString(2));
				perm.setEndDatetime(resultSet.getString(3));
				perm.setPurpose(resultSet.getString(4));
				perm.setStudentRollno(resultSet.getString(5));
				perm.setStudentName(resultSet.getString(6));
				perm.setRaisedDatetime(resultSet.getString(7));
				perm.setResponseDatetime(resultSet.getString(8));
				perm.setStatus(resultSet.getString(9));
				perm.setMessage(resultSet.getString(10));
				perm.setLabId(resultSet.getInt(11));
				perm.setMaxAudience(resultSet.getInt(12));
				
				//Finding Lab Name from lab_id
				//String query2 = "select * from Lab where lab_id="+resultSet.getInt(11);
				//ResultSet resultSet2 = statement.executeQuery(query);
				//if(resultSet2.next()){
				//	perm.setLabName(resultSet2.getString(2)); //Set Lab Name to Permission table
				//}
				
				
				list.add(perm);
			}		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			dbCon.closeDBConnection();
		}
			
		return list;
	}
	public void updateStatus(int id,String status,String message)
	{
		try{
			//Database Connection
			DBConnection dbCon=new DBConnection();
			Connection connection = dbCon.getDBConnection();
			Statement statement = connection.createStatement(); //StateMent Creation
			
			//First Query for changing the status
			String query1 = "update Permission set status='"+status+"' where event_id="+id;
			int count1 = statement.executeUpdate(query1);
			
			//Finding Date and time
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String current_datetime= dateFormat.format(cal.getTime());
			
			//Inserting date and time to  Database
			String query2 = "update Permission set response_datetime='"+current_datetime+"' where event_id="+id;
			
			int count2=statement.executeUpdate(query2);
			
			//Inserting message to Database
			int count3=-1;
			if(message!=null){ //If Lab Admin will update then message will not null, for faculty message will null
				String query3 = "update Permission set message='"+message+"' where event_id="+id;
				
				 count3=statement.executeUpdate(query3);
			}

			//Testing
			System.out.println(count1 +" count 1 row/s effected.....");
			System.out.println( count2 +" count2 row/s effected....."+ current_datetime );
			System.out.println( count3 +" count3 row/s effected....."+ message );
			
			//ResultSet resultSet = statement.executeQuery(query);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
