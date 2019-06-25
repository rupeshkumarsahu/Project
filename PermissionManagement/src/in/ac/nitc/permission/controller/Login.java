package in.ac.nitc.permission.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ac.nitc.permission.dbconnection.DBConnection;
import in.ac.nitc.permission.model.User;


@WebServlet("/login")
public class Login extends HttpServlet {
	//Method for validating or authenticating user
	public String checkAuthentication(String email,String pass) {
		DBConnection dbCon=new DBConnection();
		Connection con=dbCon.getDBConnection();
		String query="select * from User where email=? and password=?";
		PreparedStatement st;
		ResultSet rs;
		try {
			st=con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, pass);
			rs=st.executeQuery();
			//check for user authentication
			if(rs.next()) {
				String type=rs.getString("type");
				return type;
			}
			else 
				return null;
		}
	
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbCon.closeDBConnection();
		}
		return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Fetching data from Login form */
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		//Calling method for user Authentication
		
		//Creating database connection
		DBConnection dbCon=new DBConnection();
		Connection con=dbCon.getDBConnection();
		String query="select * from User where email=? and password=?";
		PreparedStatement st;
		ResultSet rs;
		try {
			st=con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, pass);
			rs=st.executeQuery();
			//check for user authentication
			if(rs.next()) {
					
				String name=rs.getString("name");
				int user_id = rs.getInt("user_id");
				String type = rs.getString("type");
				String dept=rs.getString("dept");
				//Setting session values for authorised user
				HttpSession session=request.getSession();
				session.setAttribute("user_id", user_id);
				session.setAttribute("email", email);
				session.setAttribute("name", name);
				session.setAttribute("type", type);
				session.setAttribute("dept", dept);
				
				//If the user is faculty incharge then show faculty incharge home page
				if(type.equalsIgnoreCase("faculty_incharge")) {
					response.sendRedirect("facultyInchargeView.jsp");
				}
				else{
					//User is student then fetch roll no from Student table for future references
					String rollno=null;
					query="select * from Student where user_id=?";
					st=con.prepareStatement(query);
					st.setInt(1, user_id);
					rs=st.executeQuery();
					if(rs.next()) {
						rollno=rs.getString("rollno");
						session.setAttribute("rollno", rollno);
					}
					if(type.equalsIgnoreCase("student"))
						response.sendRedirect("studentView.jsp");
					else if(type.equalsIgnoreCase("student_lab_admin"))
						response.sendRedirect("studentLabAdminView.jsp");
				}
				
			}
			else {
				PrintWriter out=response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Nitc Email Id or Password incorrect');");
				out.println("location='loginView.jsp';");
				out.println("</script>");
				//response.sendRedirect("loginView.jsp");
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbCon.closeDBConnection();
		}
		
	}

	

}
