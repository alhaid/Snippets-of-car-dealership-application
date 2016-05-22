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

@WebServlet("/addItem")
public class addItemServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User)sess.getAttribute("user");
		if( u == null) {
			response.sendRedirect("Login?msg=You Have to login first");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addItem.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemName = request.getParameter("itemName");
		String itemQty = request.getParameter("itemQty");
		String uID = request.getParameter("userId");
		try{
			int qty = Integer.parseInt(itemQty);
			int uid = Integer.parseInt(uID);
			
			DB_Access db = new DB_Access();
			if(db.addNewItem(itemName, qty, uid))
				response.sendRedirect("Home?msg=item successfully inserted");
			else
				response.sendRedirect("addItem?msg=error, fix it first");
		}catch(Exception e){
			response.sendRedirect("addItem?msg=QTY, must be a rumber only!");
		}
	
	}

}
