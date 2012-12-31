package br.com.couto.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.couto.dao.Dao;
import br.com.couto.model.Todo;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class TodoApplicationServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		Dao dao = Dao.INSTANCE;

		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		List<Todo> todos = new ArrayList<Todo>();

		if (user != null) {
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
			todos = dao.getTodos(user.getUserId());
		}
		
		req.setAttribute("url", url);
		req.setAttribute("urlLinktext", urlLinktext);
		req.setAttribute("todos", todos);
		
		resp.sendRedirect("/paginas/TodoApplication.jsp");
	}
}