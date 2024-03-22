package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.UserDao;
@WebServlet("/signup")
public class Launch1 extends HttpServlet{

	Connection con = ConnectionFactory.getCon();
	UserDao uDao = new UserDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("uid");
		String pass = req.getParameter("upass");
		
		String res = uDao.insert(con, id, pass);
		if(res.equals("inserted"))
		{
			resp.sendRedirect("login.jsp");
		}
		else
		{
			req.getSession().setAttribute("msg", "user exists");
			resp.sendRedirect("signup.jsp");
		}
	}
}
