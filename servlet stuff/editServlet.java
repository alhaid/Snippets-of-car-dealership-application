package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
public class editServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user"); //remember session return only objects!
		if (u == null){
			response.sendRedirect("Login?msg=You need to login first!");
		}else{
			boolean success;
			int iid = -1;
			if(request.getParameter("id") != null)
				try {
					iid = Integer.parseInt(request.getParameter("id"));
				}catch(Exception e) {}
			
			testpack.DB_Access db = new testpack.DB_Access();
			testpack.Item i = db.getItemDetails(iid, u.getUid());
			if(i != null){
				request.setAttribute("i", i);
				success = true;
			}else{
				success = false;
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editItem.jsp?success=" + success);
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String itemName = request.getParameter("ItemName");
		String itemQTY = request.getParameter("ItemQTY"
				);
		String itemId = request.getParameter("itemId");
		String userId= request.getParameter("userId");
		boolean success = true;
		
		//getting all the items from the DB.
		DB_Access db = new DB_Access();
		Item i = db.getItemDetails(Integer.parseInt(itemId), Integer.parseInt(userId));
		
		
			//get item name
			if(itemName != null && !itemName.equals("")){	
				itemName = request.getParameter("ItemName");
			}else{
				itemName =i.getItemName();
			}
			//get QTY
			if(itemQTY != null && !itemQTY.equals("")){
				itemQTY = request.getParameter("ItemQTY");
			}else{
				itemQTY = "" + i.getQTY();
			}
			
			
			if (OurUtils.letters(itemName) && OurUtils.numbers(itemQTY)){
				db.EditItemInfo(itemName, itemQTY, itemId, userId);
				response.sendRedirect("Home?msg=Item has been editted");
			}else{
				response.sendRedirect("Home?msg=Item has NOT been editted(wrong input)");
			}
	}

}
