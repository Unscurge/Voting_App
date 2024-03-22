package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.UserDao;
import com.Dao.VoteDao;
@WebServlet("/adminlogin")
public class Launch4 extends HttpServlet{

	Connection con = ConnectionFactory.getCon();
	UserDao uDao = new UserDao();
	VoteDao vDao = new VoteDao();
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int c1 = vDao.countVote(con, "Ram");
		int c2 = vDao.countVote(con, "Shyam");
		int c3 = vDao.countVote(con, "Raju");
		int c4 = vDao.countVote(con, "Rohit");
		
		int arr[] = {c1, c2, c3, c4};
		String id = req.getParameter("uid");
		String pass = req.getParameter("upass");
		Arrays.sort(arr);
		String winner= "";
		int mxvote=arr[arr.length-1];
		System.out.println(mxvote);
		if(mxvote == c1)
		{
			winner="Ram";
		}
		else if(mxvote ==c2)
		{
			winner="Shyam";
		}
		else if(mxvote ==c3)
		{
			winner="Raju";
		}
		else
		{
			winner="Rohit";
		}
		
		HttpSession session = req.getSession();
		if(id.equals("admin") && pass.equals("admin@123"))
		{
			session.setAttribute("checka", id);
			session.setAttribute("c1", c1);
			session.setAttribute("c2", c2);
			session.setAttribute("c3", c3);
			session.setAttribute("c4", c4);
			session.setAttribute("winner", winner);
			resp.sendRedirect("admin.jsp");
		}
		else
		{
			session.setAttribute("msg", "invalid userid or password");
			resp.sendRedirect("loginadmin.jsp");
		}
	}
}
