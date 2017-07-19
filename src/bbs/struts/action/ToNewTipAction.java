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
import bbs.biz.TopicBiz;
import bbs.struts.form.TipForm;


public class ToNewTipAction extends Action {
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
		
		BoardBiz boardBiz = new BoardBiz();
		tipForm.setBoard(boardBiz.findBoardById(tipForm.getBoard().getBoardId()));		
		
		if (tipForm.getTopic().getTopicId()==-1) {
			return mapping.findForward("newTopic");
		}else{
			TopicBiz topicBiz = new TopicBiz();
			tipForm.setTopic(topicBiz.findTopicById(tipForm.getTopic().getTopicId()));
			return mapping.findForward("newReply");

		}
	}
}