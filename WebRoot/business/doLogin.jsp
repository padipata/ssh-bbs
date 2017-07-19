<%@ page language="java" import="java.util.*,bbs.entity.*,bbs.biz.*" pageEncoding="gbk"%>


<%
	request.setCharacterEncoding("gbk");
	response.setCharacterEncoding("gbk");
	
	String userName = request.getParameter("userName");//获取用户名
	String userPwd = request.getParameter("userPwd");// 获取密码
	
	UserBiz userBiz = new UserBiz();
	User user = userBiz.doLogin(userName,userPwd);
	if(user!=null){
		session.setAttribute("LoginedUser",user);
		response.sendRedirect("../index.jsp");
	}else{
		//out.println("<script>window.alert('用户名或密码错误，请重新输入！');window.location.href='../login.jsp';</script>");
		out.println("<script>window.alert('用户名或密码错误，请重新输入！');history.back(-2);</script>");
	}
%>