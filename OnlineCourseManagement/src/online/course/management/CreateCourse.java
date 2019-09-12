package online.course.management;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCourse
 */
@WebServlet("/CreateCourse")
public class CreateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//redirecting to createCourse.jsp
		request.getRequestDispatcher("/createCourse.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//////////////////////////////////////
		
		//getting conected with the database
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed first\n");
		}
		
			String dbUrl = "jdbc:mysql://localhost:3306/online_course_management";
			String adminName = "root";
			String pass = "12345";
			
		try {
			
			
			// data from form submit
			
			
			String courseCode=request.getParameter("courseCode");
			String courseTitle = request.getParameter("courseTitle");
			double credit = Double.parseDouble(request.getParameter("credit"));
			int year = Integer.parseInt(request.getParameter("year"));
			int semester = Integer.parseInt(request.getParameter("semester"));
			
			
			Connection connection = DriverManager.getConnection(dbUrl,adminName,pass);
			
			//inserting the newly created course into the course table
			String query = String.format("insert into course (courseCode, courseTitle, credit, year, semester) values ('%s','%s',%f,%d,%d)",courseCode, courseTitle, credit, year, semester);
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			
			//sending an attribute value to adminHome.jsp
			request.setAttribute("msg","added");
			request.getRequestDispatcher("/adminHome.jsp").forward(request, response);
	
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed\n");
		} finally {
			
		}
		
		/////////////////////////////////////
	}

}
