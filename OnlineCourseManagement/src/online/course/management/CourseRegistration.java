package online.course.management;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CourseRegistration
 */
@WebServlet("/CourseRegistration")
public class CourseRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//sending to the courseReistration.jsp where the form resides
		request.getRequestDispatcher("/courseRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//main idea is to enable a student to register for a course
		
		
		//getting the driver for the Java Database Connector
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("Error Occured");
		}
		
		
		//getting the url, admin name and password to access the database
		String dbUrl = "jdbc:mysql://localhost:3306/online_course_management";
		String adminName = "root";
		String pass = "12345";
		
		try {
			
			// data from form submit
			String courseCode = request.getParameter("courseCode");
			String courseTitle = request.getParameter("courseTitle");
			
			//System.out.println(courseCode + "  " + courseTitle);
			
			
			//getting the connection with the database
			Connection connection = DriverManager.getConnection(dbUrl,adminName,pass);
			
			
			//finding the student id from session attribute
			HttpSession session = request.getSession();
			int id = Integer.parseInt(session.getAttribute("id").toString());
			
			//System.out.println("printing id "+id);
			
			//finding the email of the student to store in the enrolledCourses table
			String emailFind = String.format("select email from user where id = %d",id);
			ResultSet email = connection.createStatement().executeQuery(emailFind);
			
			String studentEmail = null;
			
			if(email.next()) {
				studentEmail = email.getString("email");
			}
			
			//inserting the enrollment in the enrolledCourses table
			String queryInsert = String.format("insert into enrolledCourses (courseCode,courseTitle,studentEmail) values ('%s','%s','%s')",courseCode,courseTitle,studentEmail);
			connection.createStatement().executeUpdate(queryInsert);
			
			connection.close();
			//redirecting to registerCourses.jsp
			response.sendRedirect("registeredCourses");
			
			//request.getRequestDispatcher("/registeredCourses.jsp").forward(request, response);
	
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed\n");
		} 
		
	}

}
