package in.ac.nitc.permission.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.nitc.permission.model.Permission;
import in.ac.nitc.permission.dbconnection.*;

/**
 * Servlet implementation class GetAdminController
 */
@WebServlet("/getAdmin")
public class GetAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String choice= request.getParameter("choice");
		
		//PermissionDataDao permissionDao= new PermissionDataDao();
		Permission p =new Permission();
		
		ArrayList<Permission> list= p.getObject(choice);
		
		request.setAttribute("permission_list",list);
		if(choice.equals("lab_admin"))
		{
			RequestDispatcher rDispatcher = request.getRequestDispatcher("adminViewRaised.jsp");
			rDispatcher.forward(request, response);
		}else if(choice.equals("approved")){
			RequestDispatcher rDispatcher = request.getRequestDispatcher("adminViewApproved.jsp");
			rDispatcher.forward(request, response);
		}else if(choice.equals("faculty_incharge")){
			RequestDispatcher rDispatcher = request.getRequestDispatcher("facultyViewRaised.jsp");
			rDispatcher.forward(request, response);
			
		}else if(choice.equals("pending")){
			RequestDispatcher rDispatcher = request.getRequestDispatcher("facultyViewPending.jsp");
			rDispatcher.forward(request, response);
			
		}else if(choice.equals("declined")){
			RequestDispatcher rDispatcher = request.getRequestDispatcher("facultyViewDeclined.jsp");
			rDispatcher.forward(request, response);
			
		}

	}

	

}
