package br.com.couto.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.couto.dao.Dao;

@SuppressWarnings("serial")
public class RemoveTodoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String id = req.getParameter("id");
		Dao.INSTANCE.remove(Long.parseLong(id));
		resp.sendRedirect("/TodoApplication.jsp");
	}
}