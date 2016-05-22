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

@WebServlet("/view")
public class viewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		if( u == null) {
			response.sendRedirect("Login?msg=You Have to login first");
		}
		else {
			int iid = -1;
			if(request.getParameter("id") != null)
				try {
					iid = Integer.parseInt(request.getParameter("id"));
				}catch(Exception e) {}
			
			DB_Access db = new testpack.DB_Access();
			Item i = db.getItemDetails(iid, u.getUid());
			request.setAttribute("item", i);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/viewItem.jsp");
			rd.forward(request, response);
		}
	}
}
