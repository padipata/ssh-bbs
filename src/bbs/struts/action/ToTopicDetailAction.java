/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package bbs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import bbs.biz.BoardBiz;
import bbs.biz.ReplyBiz;
import bbs.biz.TopicBiz;
import bbs.biz.UserBiz;
import bbs.entity.Topic;
import bbs.struts.form.TipForm;

/** 
 * MyEclipse Struts
 * Creation date: 10-24-2016
 * 
 * XDoclet definition:
 * @struts.action path="/toTopicDetailAction" name="tipForm" scope="request"
 */
public class ToTopicDetailAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TipForm tipForm = (TipForm) form;
		
		int boardId = tipForm.getBoard().getBoardId();
		int topicId = tipForm.getTopic().getTopicId();
		int page = tipForm.getPage();
		
		BoardBiz boardBiz = new BoardBiz();
		TopicBiz topicBiz = new TopicBiz();
		ReplyBiz replyBiz = new ReplyBiz();
		UserBiz userBiz = new UserBiz();
				
		Topic topic = topicBiz.findTopicById(topicId);
		
		tipForm.setBoard(boardBiz.findBoardById(boardId));
		tipForm.setTopic(topic);
		tipForm.setPageCount((replyBiz.findCountReply(topicId)+9)/10);		
		
		request.setAttribute("topicUser",userBiz.findUserByUserId(topic.getUserId()));
		request.setAttribute("replyList", replyBiz.findReplyList(page, topicId));
		
		return mapping.findForward("topicDetail");
	}
}