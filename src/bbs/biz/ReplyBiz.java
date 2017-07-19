package bbs.biz;

import bbs.dao.*;
import bbs.dao.impl.*;
import bbs.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ReplyBiz {
	IReplyDAO replyDAO=new ReplyDAO();
	IUserDAO userDAO=new UserDAO();
	
	public int findCountReply(int topicId){
		return replyDAO.findCountReply(topicId);
	}
	
	public List<ReplyListBean> findReplyList(int page, int topicId){		
		List<ReplyListBean> listBean = new ArrayList<ReplyListBean>();
		for(Reply reply : replyDAO.findReplyList(page, topicId)){
			User user = userDAO.findUserByUserId(reply.getUserId());
			ReplyListBean replyBean = new ReplyListBean(reply,user);
			listBean.add(replyBean);
			
		}
			
		return listBean;
	}
	
	public Reply findReplyById(int replyId) {
		return replyDAO.findReplyById(replyId);
	}
	public boolean addReply(Reply reply){
		return replyDAO.addReply(reply);
	}
	
	public boolean updateReply(Reply reply){
		
	    return replyDAO.updateReply(reply);
	}
	
	public boolean deleteReply(int replyId){ 
		return replyDAO.deleteReply(replyId);
	}
}