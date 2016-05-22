package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/create-account.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName = "", loginPass = "", fullName = "";
		boolean canValidate = true;
		if(OurUtils.validTextInput(request.getParameter("uname")))
			loginName = request.getParameter("uname");
		else canValidate = false;
		if(OurUtils.validTextInput(request.getParameter("name")))
			fullName = request.getParameter("name");
		else canValidate = false;
		if(OurUtils.validTextInput(request.getParameter("upass")))
			loginPass = request.getParameter("upass");
		else canValidate = false;
		if(canValidate) {
			// send input to the database to be inserted
			DB_Access db = new DB_Access();
			boolean success = db.createAccount(loginName, loginPass, fullName);
			if(success) {
				// account successfully created
				response.sendRedirect("Login");
			}
			else {
				// database did not add a row, most likely the login name unique
				// constraint was violated
				response.sendRedirect("CreateAccount?msg=login name already exist, choose a different one");
			}
		}
		else {
			// send back to the create account page with the error message
			response.sendRedirect("CreateAccount?msg=wrong values, try again");
		}
	}
}
