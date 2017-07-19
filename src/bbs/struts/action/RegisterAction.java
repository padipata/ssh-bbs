package bbs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import bbs.biz.UserBiz;
import bbs.entity.User;
public class RegisterAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		
		UserBiz userBiz = new UserBiz();
		String userName = request.getParameter("userName");
		
		if (userBiz.isExistUser(userName)) {
			return mapping.findForward("RegisterFailure");
		} else {

			String userPwd = request.getParameter("userPwd");
			boolean gender = Boolean.valueOf(request.getParameter("gender"));
			String head = request.getParameter("head");
			
			User regUser = new User();
			regUser.setGender(gender);
			regUser.setHead(head);
			regUser.setUserName(userName);
			regUser.setUserPwd(userPwd);

			
			if (userBiz.addUser(regUser)) {
				return mapping.findForward("RegisterSuccess");
			}
				return mapping.findForward("RegisterFailure");
		}
	}
}