package bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.biz.*;
import bbs.entity.*;

@SuppressWarnings("serial")
public class doNewReplyServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");

		String title = request.getParameter("tipTitle");
		String content = request.getParameter("tipContent");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		User user = (User) session.getAttribute("LoginedUser");

		int boardId = Integer.valueOf(request.getParameter("boardId")); //保留现场
		int topicId = Integer.valueOf(request.getParameter("topicId"));

		ReplyBiz replyBiz = new ReplyBiz();
		Reply reply = new Reply();
		reply.setContent(content);
		reply.setTitle(title);
		reply.setUserId(user.getUserId());
		reply.setTopicId(topicId);

		String href = String.format("toTopicDetailServlet?page=1&boardId=%d&topicId=%d", boardId,topicId);

		if (replyBiz.addReply(reply)) {
			out.println("<script>window.alert('回帖发布成功');window.location.href='"+ href + "'</script>");
		} else {
			out.println("<script>window.alert('回帖发布失败');window.location.href='"+ href + "'</script>");
		}

	}

}
