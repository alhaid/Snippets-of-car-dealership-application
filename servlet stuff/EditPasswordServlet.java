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

@WebServlet("/EditPassword")
public class EditPasswordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		if( u == null) {
			response.sendRedirect("Login?msg=You Have to login first");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/EditPassword.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPassword = request.getParameter("currentType");
		String newPassword = request.getParameter("newPassword");
		String newPassword2 = request.getParameter("newPassword2");
		
		HttpSession sess = request.getSession();
		User u = (User)sess.getAttribute("user");
		
		DB_Access db = new DB_Access();
		String password = db.password("" + u.getUid());
		
		if(password.equals(currentPassword)){
			if(newPassword.equals(newPassword2)){
				db.updatePassword(newPassword, ""+u.getUid());
				response.sendRedirect("EditPassword?msg=password has been changed successfully");
			}else{
				response.sendRedirect("EditPassword?msg=the new password does not match!");
			}
		}else{
			response.sendRedirect("EditPassword?msg=current password is wrong!");
		}
	}

}
