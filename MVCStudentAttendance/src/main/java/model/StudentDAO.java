package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class StudentDAO 
{
    static Connection con;  
    static
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm?user=root&password=sql@123");
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }
	public int insertStudentDetails(StudentDTO dto)
	{
		//Fetch the value from DTO class By getter method
		String studentName=dto.getStudentName();
		String batchCode=dto.getBatchCode();
		int totalClasses=dto.getTotalClasses();
		int attendedClasses=dto.getAttendedClasses();
		boolean result=false;
		//declare the resources
		PreparedStatement pstmt;
		int count=0;
		
		//Write the Query
		String query="insert into studentattendancedetails(studentname,batchcode,totalclasses,attendedclasses) values(?,?,?,?)";
		//create platform
		try {
			pstmt=con.prepareStatement(query);
			//set values at placeholder
			pstmt.setString(1,studentName);
			pstmt.setString(2,batchCode);
			pstmt.setInt(3,totalClasses);
			pstmt.setInt(4,attendedClasses);
			
		   //execute the query
			count=pstmt.executeUpdate();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return count;
	}
	public ArrayList<StudentDTO> getStudentDetails() throws SQLException 
	{
		//Declare the resources
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<StudentDTO> list=new ArrayList();
		
		//write the query
		String query="select * from studentattendancedetails";
		
		//create the platform
		pstmt =con.prepareStatement(query);
		rs=pstmt.executeQuery();
		while(rs.next()) 
		{ 
			StudentDTO dto = new StudentDTO();
			dto.setStudentId(rs.getInt(1));
			dto.setStudentName(rs.getString(2));
			dto.setBatchCode(rs.getString(3));
			dto.setTotalClasses(rs.getInt(4));
			dto.setAttendedClasses(rs.getInt(5));
			list.add(dto);
			
			
		}
		return list;
	}
	

}
