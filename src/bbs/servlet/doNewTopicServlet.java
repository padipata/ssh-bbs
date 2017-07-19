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
public class doNewTopicServlet extends HttpServlet {

	
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

		TopicBiz topicBiz = new TopicBiz();
		Topic topic = new Topic();
		topic.setContent(content);
		topic.setTitle(title);
		topic.setBoardId(boardId);
		topic.setUserId(user.getUserId());

		String href = String.format("toTopicListServlet?page=1&boardId=%d",boardId);

		if (topicBiz.addTopic(topic)) {
			out.println("<script>window.alert('主帖发布成功');window.location.href='"+ href + "'</script>");
		} else {
			out.println("<script>window.alert('主帖发布失败');window.location.href='"+ href + "'</script>");
		}
	}

}
