package in.ac.nitc.permission.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ac.nitc.permission.model.Permission;
import in.ac.nitc.permission.model.Student;

/**
 * Servlet implementation class RaisePermission
 */
@WebServlet("/raisePermission")
public class RaisePermission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
				
		try {
			
			String studentName=(String)session.getAttribute("name");
			String studentRollNumber=(String)session.getAttribute("rollNumber");
			String department=(String)session.getAttribute("department");
			String lab=(String)session.getAttribute("lab");
			int maxAudience=(int) session.getAttribute("maxAudience");
			String eventStartDate=(String)session.getAttribute("eventStartDate");
			String eventStartTime=(String)session.getAttribute("eventStartTime");
			String eventEndDate=(String)session.getAttribute("eventEndDate");
			String eventEndTime=(String)session.getAttribute("eventEndTime");
			String eventPurpose=(String)session.getAttribute("eventPurpose");
			
			//modifying data to insert into databases
			String eventStartDateTime=eventStartDate+" "+eventStartTime+":00";
			String eventEndDateTime=eventEndDate+" "+eventEndTime+":00";	
			
			System.out.println(eventStartDateTime);
			System.out.println(eventEndDateTime);
			

			Permission pd=new Permission();
			

			pd.setDept(department);
			pd.setEndDatetime(eventEndDateTime);
			pd.setPurpose(eventPurpose);
			pd.setStartDatetime(eventStartDateTime);
			pd.setLab(lab);
			pd.setMaxAudience(maxAudience);
			pd.setStudentName(studentName);
			pd.setStudentRollno(studentRollNumber);
			
			
			Student s1=new Student();
			boolean result = s1.raisePermission(pd);
			//PermissionDataDao dao=new PermissionDataDao();
			//Permission p=new Permission();
			//boolean result=p.insertPermissionData(pd);
			
			if(!result){
				PrintWriter out=response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Some Error Occured. Please try again');");
				if(session.getAttribute("type").equals("student"))
					out.println("location='studentView.jsp';");
				else if(session.getAttribute("type").equals("student_lab_admin"))
					out.println("location='studentLabAdminView.jsp';");
				out.println("</script>");
			}
			else {
				PrintWriter out=response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Permission Raised Successfully. Thank you!');");
				if(session.getAttribute("type").equals("student"))
					out.println("location='studentView.jsp';");
				else if(session.getAttribute("type").equals("student_lab_admin"))
					out.println("location='studentLabAdminView.jsp';");
				out.println("</script>");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			
			
			session.removeAttribute("rollNumber");
			session.removeAttribute("department");
			session.removeAttribute("lab");
			session.removeAttribute("maxAudience");
			session.removeAttribute("eventStartDateTime");
			session.removeAttribute("eventEndDateTime");
			session.removeAttribute("eventPurpose");
			
		}
	}

	

}
