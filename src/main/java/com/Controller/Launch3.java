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
import com.Dao.VoteDao;
@WebServlet("/voteProcess")
public class Launch3 extends HttpServlet {
	
	Connection con = ConnectionFactory.getCon();
	VoteDao vDao= new VoteDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("uid");
		String vote = req.getParameter("candidatename");
		
		String res= vDao.insert(con, id, vote);
		HttpSession session = req.getSession();
		if(res.equals("inserted"))
		{
			session.removeAttribute("check");
			session.setAttribute("msg", "vote submitted");
			resp.sendRedirect("home.jsp");
		}
		else
		{
			session.setAttribute("msg", "already submited");
			session.removeAttribute("check");
			resp.sendRedirect("home.jsp");
		}
	}

}
