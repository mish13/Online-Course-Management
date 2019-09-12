package online.course.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisteredCourses
 */
@WebServlet("/RegisteredCourses")
public class RegisteredCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisteredCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//main idea is to find the registered courses of a student
		
		//getting connected with the database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("Error Occured");
		}
		
		String dbUrl = "jdbc:mysql://localhost:3306/online_course_management";
		String adminName = "root";
		String pass = "12345";
		
	try {
			
			// data from form submit
			
			
			
			
			Connection connection = DriverManager.getConnection(dbUrl,adminName,pass);
			
			HttpSession session = request.getSession();
			
			int id = Integer.parseInt(session.getAttribute("id").toString());
			
			System.out.println("printing id "+id);
			
			String emailFind = String.format("select email from user where id = %d",id);
			ResultSet email = connection.createStatement().executeQuery(emailFind);
			
			String studentEmail = null;
			
			if(email.next()) {
				studentEmail = email.getString("email");
			}
			
			System.out.println("printing email id "+studentEmail);

			//querying the courses of a student
			String queryCourses = String.format("select courseCode,courseTitle from enrolledCourses where studentEmail = '%s'",studentEmail);
			
			ResultSet rs = connection.createStatement().executeQuery(queryCourses);
			
			//passing the result to the registeredCourses.jsp
			request.setAttribute("courseInfo",rs);
			request.getRequestDispatcher("/registeredCourses.jsp").forward(request, response);
	
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed\n");
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
