package bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bbs.biz.*;


@SuppressWarnings("serial")
public class toModifyReplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		BoardBiz boardBiz = new BoardBiz();
		int boardId = Integer.valueOf(request.getParameter("boardId"));
		request.setAttribute("board", boardBiz.findBoardById(boardId));

		TopicBiz topicBiz = new TopicBiz();
		int topicId = Integer.valueOf(request.getParameter("topicId"));
		request.setAttribute("topic", topicBiz.findTopicById(topicId));

		ReplyBiz replyBiz = new ReplyBiz();
		int replyId = Integer.valueOf(request.getParameter("replyId"));
		request.setAttribute("reply", replyBiz.findReplyById(replyId));
		
		request.getRequestDispatcher("/modifyreply.jsp").forward(request, response);
		
		
	}

}
