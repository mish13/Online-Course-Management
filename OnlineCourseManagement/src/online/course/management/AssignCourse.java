package online.course.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AssignCourse
 */
@WebServlet("/AssignCourse")
public class AssignCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//send assignCourse.jsp
		request.getRequestDispatcher("/assignCourse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/////////////////////////////
		
		//get the driver for Java Database Connector
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed first\n");
		}
		
		//provide the database url, admin name and password
		String dbUrl = "jdbc:mysql://localhost:3306/online_course_management";
		String adminName = "root";
		String pass = "12345";
			
		try {
			
			//receive the values of the parameters from Assign Course form
			
			String courseCode=request.getParameter("courseCode");
			String courseTitle = request.getParameter("courseTitle");
			String teacherName=request.getParameter("teacherName");
			String teacherEmail = request.getParameter("teacherEmail");
			
			//get the connection with the database
			Connection connection = DriverManager.getConnection(dbUrl,adminName,pass);
			
			//insert the assign course entity into the assign table
			String query = String.format("insert into assign (courseCode, courseTitle, teacherName, teacherEmail) values ('%s','%s','%s','%s')",courseCode, courseTitle, teacherName, teacherEmail);
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			
			//pass a message using the request to adminHome.jsp
		    request.setAttribute("msg","assigned");
			request.getRequestDispatcher("/adminHome.jsp").forward(request,response);
	
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed\n");
		} finally {
			
		}
		
		
		////////////////////////////
	}

}
