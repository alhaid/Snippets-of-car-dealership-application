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

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		if( u == null) {
			response.sendRedirect("Login?msg=You Have to login first");
		}
		else {
			int iid = -1;
			try{
				iid = Integer.parseInt(request.getParameter("id"));
			}catch(Exception e) {}
			int uId = u.getUid();
			DB_Access db = new DB_Access();
			Item item = db.getItemDetails(iid, uId);
			request.setAttribute("item", item);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deleteItem.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userId");
		String itemID = request.getParameter("itemId");
		
		DB_Access db = new DB_Access();
		boolean success = db.DeleteItem(itemID, userID);
		
		if(success){
			response.sendRedirect("Home?msg=Item has been deleted");
		}else{
			response.sendRedirect("Home?msg=Item has Not been deleted");
		}
	}

}
