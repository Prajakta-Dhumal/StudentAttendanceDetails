package model;

public class StudentDTO
{
	private int studentId;
	private String studentName;
	private String batchCode;
	private int totalClasses;
	private int attendedClasses;
	public int getStudentId() 
	{
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public int getTotalClasses() {
		return totalClasses;
	}
	public void setTotalClasses(int totalClasses) {
		this.totalClasses = totalClasses;
	}
	public int getAttendedClasses() {
		return attendedClasses;
	}
	public void setAttendedClasses(int attendedClasses) {
		this.attendedClasses = attendedClasses;
	}
	
	

}
