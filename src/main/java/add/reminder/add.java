package add.reminder;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import add.reminder.dao.adddao;
@WebServlet("/add")
public class add extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		int time = Integer.parseInt(request.getParameter("time"));
		String date = request.getParameter("date");
		String label = request.getParameter("label");
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		adddao dao = new adddao();
		
		if(dao.fill(email,time,date,label))
		{
			session.setAttribute("time",time);
			session.setAttribute("date",date);
			session.setAttribute("label",label);
			response.sendRedirect("showreminder.jsp");
		}
		
	}

}
