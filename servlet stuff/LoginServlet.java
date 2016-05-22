package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		if(OurUtils.validateTextInput(uname) &&
				OurUtils.validateTextInput(upass)) {
			// input is valid, send it to the database 
			DB_Access db = new DB_Access();
			User u = db.validateLogin(uname, upass);
			if(u == null) {
				// input values are wrong, send to login page with error message
				response.sendRedirect("Login?msg=Wrong Values, Try Again");
			}
			else {
				// input values are correct, send to the home page
				request.getSession().setAttribute("user", u);
				response.sendRedirect("Home");
			}
		}
		else {
			// input is invalid, back to the login form
			response.sendRedirect("Login?msg=Wrong Values, Try Again");
		}
	}
}
