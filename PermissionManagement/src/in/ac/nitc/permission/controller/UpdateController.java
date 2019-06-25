package in.ac.nitc.permission.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.nitc.permission.model.AuthorityIncharge;
import in.ac.nitc.permission.model.Permission;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/updateStatus")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //This page redirect from both LabAdmin and Faculty based on change_status
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		int id= Integer.parseInt(request.getParameter("submit_id"));
		String status = request.getParameter("change_status");
		String message = request.getParameter("message");
		
		
		System.out.println("Event id=="+id+" change status="+status+" Message="+message);
		
		AuthorityIncharge obj = new AuthorityIncharge();
		obj.updateRaisedPermission(id, status,message);
		
		
		//PermissionDataDao permissionDao = new PermissionDataDao();
		//Permission p = new Permission();
		//p.updateStatus(id, status);
		
		if(status.equals("faculty_incharge"))
		{
			RequestDispatcher rDispatcher = request.getRequestDispatcher("index.jsp");
			rDispatcher.forward(request, response);
		}else{
			RequestDispatcher rDispatcher = request.getRequestDispatcher("facultyInchargeView.jsp");
			rDispatcher.forward(request, response);
		}

		
	}

	

}
