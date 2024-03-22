package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.UserDao;
@WebServlet("/login")
public class Launch2 extends HttpServlet{

	Connection con = ConnectionFactory.getCon();
	UserDao uDao = new UserDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("uid");
		String pass = req.getParameter("upass");
		
		String res = uDao.checkUser(con, id, pass);
		HttpSession session = req.getSession();
		if(res.equals("exits"))
		{
			session.setAttribute("check", id);
			resp.sendRedirect("Votting.jsp");
		}
		else
		{
			session.setAttribute("msg", "invalid userid or password");
			resp.sendRedirect("login.jsp");
		}
	}
}
