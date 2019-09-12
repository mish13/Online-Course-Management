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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AssignedCourses
 */
@WebServlet("/AssignedCourses")
public class AssignedCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignedCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//main idea is to find the assigned courses of a teacher
		
		
		//get the driver for the Java Database Connector
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			
			//getting the database url, admin name and password to access the database
			String dbUrl = "jdbc:mysql://localhost:3306/online_course_management";
			String adminName = "root";
			String pass = "12345";
			
			
			//getting the connection with the database
			Connection connection = DriverManager.getConnection(dbUrl,adminName,pass);
			
			//get the teahcer id to query from the table
			HttpSession session = request.getSession();
			int id = Integer.parseInt(session.getAttribute("id").toString());
			
			//System.out.println("Printing id of teacher " + id);
			
			
			//get the assigned courses' information
			String query = String.format("select assign.courseCode,assign.courseTitle from assign,user where user.id = %d and user.email = assign.teacherEmail",id);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			

			//passing the information to assignedCourses.jsp
			request.setAttribute("courseInfo", rs);
			request.getRequestDispatcher("/assignedCourses.jsp").forward(request, response);
			
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
