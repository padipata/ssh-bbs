<%@ page language="java" import="java.util.*,bbs.entity.*,bbs.biz.*" pageEncoding="gbk"%>


<%
	request.setCharacterEncoding("gbk");
	response.setCharacterEncoding("gbk");

	String title = request.getParameter("tipTitle");
	String content = request.getParameter("tipContent");
	
	int boardId = Integer.valueOf(request.getParameter("boardId")); // 保留现场
	int topicId = Integer.valueOf(request.getParameter("topicId"));// 保留现场
	
	User user = (User) session.getAttribute("LoginedUser");
	
	ReplyBiz replyBiz = new ReplyBiz();
	Reply reply = new Reply();
	reply.setContent(content);
	reply.setTitle(title);
	reply.setUserId(user.getUserId());
	reply.setTopicId(topicId);
	
	String href = String.format("../topicdetail.jsp?page=1&boardId=%d&topicId=%d",boardId,topicId);
	if(replyBiz.addReply(reply)){
		out.println("<script>window.alert('回贴发布成功！');window.location.href='"+href+"';</script>");
	}else{
		out.println("<script>window.alert('回贴发布失败！');window.location.href='"+href+"';</script>");
	}
	
%>	