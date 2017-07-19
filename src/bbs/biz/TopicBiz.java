package bbs.biz;

import java.util.ArrayList;
import java.util.List;

import bbs.dao.IReplyDAO;
import bbs.dao.ITopicDAO;
import bbs.dao.IUserDAO;
import bbs.dao.impl.ReplyDAO;
import bbs.dao.impl.TopicDAO;
import bbs.dao.impl.UserDAO;
import bbs.entity.Topic;
import bbs.entity.TopicListBean;
import bbs.entity.User;

public class TopicBiz {

	ITopicDAO topicDAO = new TopicDAO();
	IReplyDAO replyDAO = new ReplyDAO();
	IUserDAO userDAO = new UserDAO();

	public List<TopicListBean> findTopicList(int page, int boardId) {
		
		List<TopicListBean> listBean = new ArrayList<TopicListBean>();
		for(Topic topic : topicDAO.findTopicList(page, boardId)){
			User user = userDAO.findUserByUserId(topic.getUserId());
			int replyCount = replyDAO.findCountReply(topic.getTopicId());
			
			//封装业务数据
			TopicListBean topicBean = new TopicListBean(topic, user, replyCount);
			listBean.add(topicBean);
			
		}
		return listBean;
	}

	public int findCountTopic(int boardId) {

		return topicDAO.findCountTopic(boardId);
	}

	public Topic findTopicById(int topicId) {

		return topicDAO.findTopicById(topicId);
	}

	public boolean addTopic(Topic topic) {

		return topicDAO.addTopic(topic);
	}

	public boolean deleteTopic(int topicId) {

		return topicDAO.deleteTopic(topicId);
	}

}
