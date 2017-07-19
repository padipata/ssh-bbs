<%@ page language="java" import="java.util.*,bbs.entity.*,bbs.biz.*" pageEncoding="gbk"%>


<%
	request.setCharacterEncoding("gbk");
	response.setCharacterEncoding("gbk");
	
	int boardId = Integer.valueOf(request.getParameter("boardId"));
	int topicId = Integer.valueOf(request.getParameter("topicId"));
	int replyId = Integer.valueOf(request.getParameter("replyId"));
	
	if(replyId==-1){
		String href = String.format("../topiclist.jsp?page=1&boardId=%d",boardId);
		TopicBiz topicBiz = new TopicBiz();
		if(topicBiz.deleteTopic(topicId)){
			out.println("<script>window.alert('主帖删除成功！');window.location.href='"+href+"';</script>");
		
		}else{
			out.println("<script>window.alert('主帖删除失败！');window.location.href='"+href+"';</script>");
		}
	
	}else{
		String href = String.format("../topicdetail.jsp?page=1&boardId=%d&topicId=%d",boardId,topicId);
		ReplyBiz replyBiz = new ReplyBiz();
	if(replyBiz.deleteReply(replyId)){
		out.println("<script>window.alert('回帖删除成功！');window.location.href='"+href+"';</script>");
		
	}else{
		out.println("<script>window.alert('回帖删除失败！');window.location.href='"+href+"';</script>");
	}
	
	}
	
	
	
%>	