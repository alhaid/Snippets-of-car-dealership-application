package testpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditUserName")
public class EditUserNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		if( u == null) {
			response.sendRedirect("Login?msg=You Have to login first");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/EditUserName.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User)sess.getAttribute("user");
		DB_Access db = new DB_Access();
		
		String userName = request.getParameter("userName");
		String loginName = request.getParameter("LoginName");
		
		if(db.checkLoginName(loginName)){
		
			if(userName != null && !userName.equals("")){
				userName = request.getParameter("userName");
			}else{
				userName = u.getFulName();
			}
			
			if(loginName != null && !loginName.equals("")){
				loginName = request.getParameter("LoginName");
			}else{
				loginName = u.getLoginName();
			}
			
			if (OurUtils.letters(userName) && OurUtils.letters(loginName)){
				db.UpdateUserName(userName, loginName, "" + u.getUid());
				u.setFulName(userName);
				u.setLoginName(loginName);
				sess.setAttribute("user", u);
				response.sendRedirect("EditUserName?msg=Changes has been made");
			}else{
				response.sendRedirect("EditUserName?msg=Changes has NOT been made");
			}
		
		}else{
			response.sendRedirect("EditUserName?msg=this login name already exists! try another one");
		}
	}
}
