package ecommerce;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		PrintWriter pw = response.getWriter();
		ResultSet da = new loginDAO().check(uname, pword);
		if(da==null) {
			request.setAttribute("msg", "Invalid username and password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "valid username and password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
