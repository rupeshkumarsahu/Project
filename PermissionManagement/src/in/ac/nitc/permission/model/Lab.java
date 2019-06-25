package in.ac.nitc.permission.model;

public class Lab {
	private int lab_id;
	private String lab_name;
	private String lab;
	private String room_number;
	private String dept;
	private int capacity;
	private int availability;
	public int getLabId() {
		return lab_id;
	}
	public void setLabId(int lab_id) {
		this.lab_id = lab_id;
	}
	public String getLabName() {
		return lab_name;
	}
	public void setLabName(String lab_name) {
		this.lab_name = lab_name;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getRoomNumber() {
		return room_number;
	}
	public void setRoomNumber(String room_number) {
		this.room_number = room_number;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	

}
