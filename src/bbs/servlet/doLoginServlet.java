package bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.biz.UserBiz;
import bbs.entity.User;

@SuppressWarnings("serial")
public class doLoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		
		String userName = request.getParameter("userName");//获取用户名
		String userPwd = request.getParameter("userPwd");// 获取密码
		
		UserBiz userBiz = new UserBiz();
		User user = userBiz.doLogin(userName,userPwd);
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(user!=null){
			session.setAttribute("LoginedUser",user);
			response.sendRedirect("index.jsp");
		}else{
			out.println("<script>window.alert('用户名或密码错误，请重新输入！');history.back(-2);</script>");
		}
	}

}
