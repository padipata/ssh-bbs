<%@ page language="java" import="java.util.*,bbs.entity.*,bbs.biz.*" pageEncoding="gbk"%>


<%
	request.setCharacterEncoding("gbk");
	response.setCharacterEncoding("gbk");

	String title = request.getParameter("tipTitle");
	String content = request.getParameter("tipContent");
	
	int boardId = Integer.valueOf(request.getParameter("boardId")); // 保留现场
	
	User user = (User) session.getAttribute("LoginedUser");
	
	TopicBiz topicBiz = new TopicBiz();
	Topic topic = new Topic();
	topic.setContent(content);
	topic.setTitle(title);
	topic.setBoardId(boardId);
	topic.setUserId(user.getUserId());
	
	
	String href = String.format("../topiclist.jsp?page=1&boardId=%d",boardId);
	if(topicBiz.addTopic(topic)){
		out.println("<script>window.alert('主贴发布成功！');window.location.href='"+href+"';</script>");
	}else{
		out.println("<script>window.alert('主贴发布失败！');window.location.href='"+href+"';</script>");
	}
%>