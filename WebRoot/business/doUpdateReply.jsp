<%@ page language="java" import="java.util.*,bbs.entity.*,bbs.biz.*" pageEncoding="gbk"%>


<%
	request.setCharacterEncoding("gbk");
	response.setCharacterEncoding("gbk");
	String title = request.getParameter("tipTitle");
	String content = request.getParameter("tipContent");
	
	int replyId = Integer.valueOf(request.getParameter("replyId"));
	
	ReplyBiz replyBiz = new ReplyBiz();
	Reply reply = replyBiz.findReplyById(replyId);
	reply.setContent(content);
	reply.setTitle(title);
	
	int boardId = Integer.valueOf(request.getParameter("boardId"));
	int topicId = Integer.valueOf(request.getParameter("topicId"));
	String href = String.format("../topicdetail.jsp?page=1&boardId=%d&topicId=%d",boardId,topicId);
	if(replyBiz.updateReply(reply)){
		out.println("<script>window.alert('回帖修改成功！');window.location.href='"+href+"';</script>");
		out.println("<script>window.alert('回帖修改失败！');window.location.href='"+href+"';</script>");
	}



%>