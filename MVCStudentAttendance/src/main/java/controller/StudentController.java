package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDAO;
import model.StudentDTO;

@WebServlet(urlPatterns = {"/addstudent","/getattendance"})
public class StudentController  extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		switch(path) 
		{
		     case "/addstudent": addStudentDetails(req,resp);
		     break;
		     case "/getattendance": getStudentDetails(req,resp);
		}
	}

	private void getStudentDetails(HttpServletRequest req, HttpServletResponse resp) 
	{
		StudentDAO dao=new StudentDAO();
		ArrayList<StudentDTO> list=new ArrayList();
		try
		{
			list=dao.getStudentDetails();
			req.setAttribute("studentlist", list);
			RequestDispatcher rd=req.getRequestDispatcher("getdetails.jsp");
			rd.forward(req, resp);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	private void addStudentDetails(HttpServletRequest req, HttpServletResponse resp)
	{
		//Fetch the value from html page
		  String studentName=req.getParameter("studentname");
		  String batchCode=req.getParameter("batchcode");
		  int totalClasses=Integer.parseInt(req.getParameter("totalclasses"));
		  int attendedClasses=Integer.parseInt(req.getParameter("attendedclasses"));
		  
		  
		//pass the value to DTO class
		  StudentDTO dto=new StudentDTO();
		  dto.setStudentName(studentName);
		  dto.setBatchCode(batchCode);;
		  dto.setTotalClasses(totalClasses);
		  dto.setAttendedClasses(attendedClasses);
		  
		  //Create the Object of DAO class
		  StudentDAO dao=new StudentDAO();
		  int count=dao.insertStudentDetails(dto);
		  req.setAttribute("count",count);
		  RequestDispatcher rd=req.getRequestDispatcher("adddetails.jsp");
		  try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
