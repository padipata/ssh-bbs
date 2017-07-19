package bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.biz.BoardBiz;
import bbs.biz.TopicBiz;

@SuppressWarnings("serial")
public class toNewTipServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		//版块数据
		BoardBiz boardBiz = new BoardBiz();
		int boardId = Integer.valueOf(request.getParameter("boardId"));
		request.setAttribute("board", boardBiz.findBoardById(boardId));
		
		//主帖数据
		TopicBiz topicBiz = new TopicBiz();
		int topicId = Integer.valueOf(request.getParameter("topicId"));
		request.setAttribute("topic", topicBiz.findTopicById(topicId));
		String actionForm;
		if (topicId==-1) {
		 actionForm = "doNewTopicServlet";
		}else{
			
		 actionForm = "doNewReplyServlet";
		}
		request.setAttribute("actionForm", actionForm);
		request.getRequestDispatcher("/newtip.jsp").forward(request, response);

	}

}
