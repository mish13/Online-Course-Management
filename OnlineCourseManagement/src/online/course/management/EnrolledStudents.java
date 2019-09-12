package online.course.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EnrolledStudents
 */
@WebServlet("/EnrolledStudents")
public class EnrolledStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrolledStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//main idea is to find the enrolled students for a particular course
		String courseCode = request.getParameter("courseCode");
		
		
		//getting conected with the database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			
			//using url, admin name and password to access the database
			String dbUrl = "jdbc:mysql://localhost:3306/online_course_management";
			String adminName = "root";
			String pass = "12345";
			
			
			
			Connection connection = DriverManager.getConnection(dbUrl,adminName,pass);
			
			//querying the students' information
			String query = String.format("select user.firstName,user.lastName,user.email from user,enrolledCourses where enrolledCourses.courseCode='%s' and email = enrolledCourses.studentEmail",courseCode);
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			

			//passing the response to enrolledStudents.jsp
			request.setAttribute("courseInfo", rs);
			request.getRequestDispatcher("/enrolledStudents.jsp").forward(request, response);
			//response.getWriter().append("Hello teacher");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
