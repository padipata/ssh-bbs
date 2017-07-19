package bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.biz.*;

@SuppressWarnings("serial")
public class doDeleteTipServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");

		int boardId = Integer.valueOf(request.getParameter("boardId")); //保留现场
		int topicId = Integer.valueOf(request.getParameter("topicId")); //保留现场
		int replyId = Integer.valueOf(request.getParameter("replyId"));
		
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		if (replyId == -1) {
			String href = String.format("toTopicListServlet?page=1&boardId=%d", boardId);
			
			TopicBiz topicBiz = new TopicBiz();
			
			if (topicBiz.deleteTopic(topicId)) {
				out.println("<script>window.alert('主帖删除成功');window.location.href='"+ href + "'</script>");
			} else {
				out.println("<script>window.alert('主帖删除失败');window.location.href='"+ href + "'</script>");
			}
		} else {
			String href = String.format("toTopicDetailServlet?page=1&boardId=%d&topicId=%d",boardId, topicId);
			
			ReplyBiz replyBiz = new ReplyBiz();
			
			if (replyBiz.deleteReply(replyId)) {
				out.println("<script>window.alert('回帖删除成功');window.location.href='"+ href + "'</script>");
			} else {
				out.println("<script>window.alert('回帖删除失败');window.location.href='"+ href + "'</script>");
			}
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

		
	}

}
