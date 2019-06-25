package in.ac.nitc.permission.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class searchEvent
 */
@WebServlet("/searchEvent")
public class searchEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String startDate=request.getParameter("startDate");
		String endDate =request.getParameter("endDate");

		
		
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",endDate);
		RequestDispatcher rDispatcher = request.getRequestDispatcher("searchEvents.jsp");
		rDispatcher.forward(request, response);
	}

	

}
