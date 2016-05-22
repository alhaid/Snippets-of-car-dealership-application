package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccountInfo")
public class AccountInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User)sess.getAttribute("user");
		if(u == null){
			response.sendRedirect("Login?msg=You need to login first!");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccountInfo.jsp");
			rd.forward(request, response);
		}
	}
}
