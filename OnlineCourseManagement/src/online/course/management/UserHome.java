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
 * Servlet implementation class UserHome
 */
@WebServlet("/UserHome")
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		try {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String userRole = request.getParameter("userRole");
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8)); 
			password = Base64.getEncoder().encodeToString(hash);
			
		
			String dbUrl = "jdbc:mysql://localhost:3306/online_course_management";
			String adminName = "root";
			String pass = "12345";
			
			
			
			Connection connection = DriverManager.getConnection(dbUrl,adminName,pass);
			
			String query = String.format("select * from user where email='%s' and password='%s' and userRole='%s'",email,password,userRole);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			if(rs.next()) {
				
				//getting a session and setting session attributes
				HttpSession session = request.getSession();
				session.setAttribute("id",rs.getInt("id"));
				session.setAttribute("firstName", rs.getString("firstName"));
				session.setAttribute("lastName", rs.getString("lastName"));
				
				String role = rs.getString("userRole");
				
				
				//sending to different home pages depending on the role
				if(role.equals("Admin")) {
					request.setAttribute("msg","notassigned");
					request.getRequestDispatcher("/adminHome.jsp").forward(request, response);
					
				} else if(role.equals("Teacher")) {
					
					String mail = rs.getString("email");
					String queryCourse = String.format("select courseCode,courseTitle from assign where teacherEmail = '%s'",mail);
					ResultSet res = stmt.executeQuery(queryCourse);
					request.setAttribute("courseInfo", res);
					request.getRequestDispatcher("/teacherHome.jsp").forward(request, response);
					
				} else {
					request.getRequestDispatcher("/studentHome.jsp").forward(request, response);
				}
				
				System.out.println("From if clause");
				
			} else {
				System.out.println("Incorrect Credential");
				request.setAttribute("msg","invalid");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		

		
	}

}
