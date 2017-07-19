package bbs.biz;

import java.util.ArrayList;
import java.util.List;

import bbs.dao.*;
import bbs.dao.impl.*;
import bbs.entity.*;


public class BoardBiz {
	IBoardDAO boardDAO=new BoardDAO();  //面向接口编程
	IUserDAO userDAO=new UserDAO();
	ITopicDAO topicDAO=new TopicDAO();
		
	public Board findBoardById(int boardId){
		return boardDAO.findBoardById(boardId);
	}
	
	public List<BoardListBean> getFindBoardList() {
		
		List<BoardListBean> listBean = new ArrayList<BoardListBean>();

		for (Board board : boardDAO.findBoardList()) {
			Topic topic = new Topic();
			User user = new User();
			int topicCount = 0;
			if(board.getParentId()!=0){
				topic = topicDAO.findTopicList(1, board.getBoardId()).get(0); //获取对应板块最新的主贴
				user = userDAO.findUserByUserId(topic.getUserId());
				topicCount = topicDAO.findCountTopic(board.getBoardId());
				
			}
			// 封装业务数据
			BoardListBean boardBean = new BoardListBean(board,user,topic,topicCount);
			listBean.add(boardBean);
		}
		
		return listBean;
		
	}
}
