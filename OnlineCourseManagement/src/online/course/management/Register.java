package online.course.management;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sending the register.jsp page
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		////////////////////////////////////
		
		
		//getting connected with the database
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
			
			
			String firstName=request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String userName = request.getParameter("userName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			//hash the password
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8)); 
			password = Base64.getEncoder().encodeToString(hash);
			
			//System.out.println(password);

			String contactNo = request.getParameter("contactNo");
			String userRole = request.getParameter("userRole");
			
			
			Connection connection = DriverManager.getConnection(dbUrl,adminName,pass);
			
			
			//first checking does email already exist?
			
			String queryFirst = String.format("select * from user where email='%s'",email);
			ResultSet rs = connection.createStatement().executeQuery(queryFirst);
			
			if(rs.next() == false) {
				//if the email is unique
				String query = String.format("insert into user (firstName,lastName,userName,email,password,contactNo,userRole) values ('%s','%s','%s','%s','%s','%s','%s')",firstName,lastName,userName,email,password,contactNo,userRole);
				connection.createStatement().executeUpdate(query);
				request.setAttribute("msg","valid");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			}  else {
				
				
				//if the email is already taken
				request.setAttribute("msg","invalid");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				
			}
			
			connection.close();
	
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed\n");
		} finally {
			
		}
	}

}
