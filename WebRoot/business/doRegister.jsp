<%@ page language="java" import="java.util.*,bbs.entity.*,bbs.biz.*" pageEncoding="gbk"%>


<%
	request.setCharacterEncoding("gbk");
	response.setCharacterEncoding("gbk");
	
	UserBiz userBiz = new UserBiz();
	String userName = request.getParameter("userName");
	if(userBiz.isExistUser(userName)){
		out.println("<script>window.alert('用户名已经存在，请重新输入！');history.back(-2);</script>");
		
	}else{
		String userPwd = request.getParameter("userPwd");
		boolean gender = Boolean.valueOf(request.getParameter("gender"));
		String head = request.getParameter("head");
		
		User regUser = new User();
		regUser.setGender(gender);
		regUser.setHead(head);
		regUser.setUserName(userName);
		regUser.setUserPwd(userPwd);
		
		if(userBiz.addUser(regUser)){
			request.getRequestDispatcher("doLogin.jsp").forward(request,response);//转发登录
			
		}else{
			out.println("<script>window.alert('注册失败，请重新注册！');history.back(-2);</script>");
		}
	}
	
%>