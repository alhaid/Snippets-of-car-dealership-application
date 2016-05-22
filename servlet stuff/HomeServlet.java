package testpack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		if( u == null) {
			// someone is trying to access the home page without loging in first
			// send the intruder to the login page instead
			response.sendRedirect("Login?msg=You Have to login first");
		}
		else {
			// user is  a valid user, let him see the content
			DB_Access db = new DB_Access();
			ArrayList<Item> items = db.getAllUserItems(u.getUid());
			request.setAttribute("items", items);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}








