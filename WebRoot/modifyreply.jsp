<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@page import="bbs.entity.*"%>
<%@page import="bbs.biz.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
		<TITLE>广州科贸论坛--修改帖子</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=GBK">
		<Link rel="stylesheet" type="text/css" href="style/style.css" />
	</HEAD>

	<BODY>
		<center>
			<div id="content">
				<DIV id="header">
					&nbsp;
					<IMG src="image/logo.gif" width="100%" height="100%">
				</DIV>
				<%@include file="pageheader.jsp"%>
				<!--      用户信息、登录、注册        -->
				
				<bean:define id="board" name="tipForm" property="board"/>		
				<bean:define id="topic" name="tipForm" property="topic"/>		
				<bean:define id="reply" name="tipForm" property="reply"/>	
				
				<!--      主体        -->
				<DIV>
					<BR />
					<!--      导航        -->
					<DIV id="ww">
					
						<div style="float: left; padding-top: 6px;">
							&gt;&gt;
							<B><a href="index.jsp">论坛首页</a> </B>&gt;&gt;
							<B><a
								href="tip.do?op=toTopicList&page=1&board.boardId=<bean:write name='board' property='boardId'/> "><bean:write name="tipForm" property="board.boardName"/></a>
							</B>&gt;&gt;
							<B><a
								href="tip.do?op=toTopicDetail&page=1&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topic' property='topicId'/>"><bean:write name="topic" property="title"/></a>
							</B>
						</div>
						<FORM name="updateForm" action="tip.do?op=doModifyReply" method="post" >
							<input type="hidden" name="board.boardId" value="<bean:write name="board" property="boardId"/>">
							<input type="hidden" name="topic.topicId" value="<bean:write name="topic" property="topicId"/>">
							<input type="hidden" name="reply.replyId" value="<bean:write name="reply" property="replyId"/>">
							<DIV class="t">
								<TABLE cellSpacing="0" cellPadding="0" align="center">

									<TR>
										<TD class="h" colSpan="3">
											<B>&#20462;&#25913;&#24086;&#23376;</B>
										</TD>
									</TR>



									<TR class="tr3">
										<TH width="20%" valign="middle">
											<DIV align="center">
												<B>标题</B>
											</DIV>
										</TH>
										<TH colSpan="2">
											<INPUT id="tipTitle" name="reply.title"
												value="<bean:write name='reply' property='title'/>" class="input"
												style="PADDING-LEFT: 2px; width: 80%" tabIndex="1">
										</TH>
									</TR>

									<TR class="tr3">
										<TH vAlign="middle">
											<DIV align="center">
												<B>内容</B>
											</DIV>
										</TH>
										<TH colSpan="2">
											<DIV>
												<span><textarea id="tipContent" name="reply.content"
														style="WIDTH: 80%;" rows="20" cols="90" tabIndex="2"><bean:write name="reply" property="content"/></textarea>
												</span>
											</DIV>
											<DIV align="center">
												(不能大于：
												<FONT color="blue">1000</FONT>字)
											</DIV>

										</TH>
									</TR>

								</TABLE>
							</DIV>

							<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
								<INPUT class="btn" tabIndex="3" type="submit" value="修 改">
							</DIV>
						</FORM>
					</DIV>
					<!--      声明        -->
					<BR />
				</DIV>
				<%@include file="pagefooter.jsp"%>
			</div>
		</center>

	</BODY>
</HTML>