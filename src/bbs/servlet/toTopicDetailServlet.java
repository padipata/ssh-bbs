package bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.biz.BoardBiz;
import bbs.biz.ReplyBiz;
import bbs.biz.TopicBiz;
import bbs.biz.UserBiz;
import bbs.entity.Topic;
import bbs.entity.TopicListBean;

@SuppressWarnings("serial")
public class toTopicDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		//板块数据
		BoardBiz boardBiz = new BoardBiz();
		int boardId = Integer.valueOf(request.getParameter("boardId"));
		request.setAttribute("board", boardBiz.findBoardById(boardId));
		
		//主帖数据
		TopicListBean topicBean = new TopicListBean();
		TopicBiz topicBiz = new TopicBiz();
		UserBiz userBiz = new UserBiz();
		int topicId = Integer.valueOf(request.getParameter("topicId"));
		Topic topic = topicBiz.findTopicById(topicId);
		topicBean.setTopic(topic);
		topicBean.setUser(userBiz.findUserByUserId(topic.getUserId()));
		request.setAttribute("topicBean",topicBean);
		
		//回帖列表数据
		int page = Integer.valueOf(request.getParameter("page"));
		ReplyBiz replyBiz = new ReplyBiz();
		request.setAttribute("replyList",replyBiz.findReplyList(page, topicId));
		request.setAttribute("pageCount", (replyBiz.findCountReply(topicId)+9)/10);
		
		request.getRequestDispatcher("/topicdetail.jsp").forward(request, response);
	}

}
