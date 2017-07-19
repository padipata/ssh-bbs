package bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.biz.*;
import bbs.entity.*;

@SuppressWarnings("serial")
public class doModifyReplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String title = request.getParameter("tipTitle");
		String content = request.getParameter("tipContent");

		int replyId = Integer.valueOf(request.getParameter("replyId"));

		ReplyBiz replyBiz = new ReplyBiz();
		Reply reply = replyBiz.findReplyById(replyId);
		reply.setContent(content);
		reply.setTitle(title);

		int boardId = Integer.valueOf(request.getParameter("boardId")); //保留现场
		int topicId = Integer.valueOf(request.getParameter("topicId"));
		String href = String.format("topicdetail.jsp?page=1&boardId=%d&topicId=%d", boardId,topicId);

		PrintWriter out = response.getWriter();
		
		if (replyBiz.updateReply(reply)) {
			out.println("<script>window.alert('回帖修改成功');window.location.href='"+ href + "'</script>");
		} else {
			out.println("<script>window.alert('回帖修改失败');window.location.href='"+ href + "'</script>");
		}
	}

}
