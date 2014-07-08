/**
 * 
 */
package org.javahispano.javaleague.server.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author adou
 * 
 */
public class RegisterUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.sendRedirect(req.getScheme() + "://" + req.getServerName()
				+ req.getContextPath() + "#WelcomePlace");

	}

}
