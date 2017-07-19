package bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.biz.BoardBiz;
import bbs.biz.TopicBiz;

@SuppressWarnings("serial")
public class toTopicListServlet extends HttpServlet {

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
		TopicBiz topicBiz = new TopicBiz();
		int page = Integer.valueOf(request.getParameter("page"));
		request.setAttribute("topicList", topicBiz.findTopicList(page, boardId));
		request.setAttribute("pageCount", (topicBiz.findCountTopic(boardId)+9)/10);
		
		request.getRequestDispatcher("/topiclist.jsp").forward(request, response);
		
		

	}

}
