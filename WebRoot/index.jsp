<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@page import="bbs.entity.*"%>
<%@page import="bbs.biz.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<HEAD>
		<TITLE>欢迎访问广州科技贸易职业学院论坛</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=GBK">
		<Link rel="stylesheet" type="text/css" href="style/style.css" />
	</HEAD>

	<BODY>
	<html:errors property="UserInfo"/>
		<center>
			<div id="content">
				<DIV id="header">
					<img src="image/logo.gif" width="100%" height="100%" />
				</DIV>
				<%@include file="pageheader.jsp"%>
				<!--      主体        -->
				<DIV class="t">
					<TABLE cellSpacing="0" cellPadding="0" width="100%">
						<TR class="tr2" align="center">
							<TD colSpan="2">
								论坛
							</TD>
							<TD style="WIDTH: 10%;">
								主题
							</TD>
							<TD style="WIDTH: 30%">
								最后发表
							</TD>
						</TR>

						<jsp:useBean id="boardBiz" class="bbs.biz.BoardBiz" scope="request" />
						<bean:define id="mainBoardList" name="boardBiz"	property="findBoardList"/>
							<logic:iterate id="mainBoard" name="mainBoardList"	type="bbs.entity.BoardListBean">
								<bean:define id="board" name="mainBoard" property="board"/>
								<!--       主版块       -->
								<logic:equal value="0" name="mainBoard"
									property="board.parentId">
									<TR class="tr3">
										<TD colspan="4" align="left">
											<bean:write name="board" property="boardName" />
										</TD>
									</TR>

								</logic:equal>
								<!--       子版块       -->

								<logic:notEqual value="0" name="board" property="parentId">
									<bean:define id="topic" name="mainBoard" property="topic"/>
										<bean:define id="user" name="mainBoard" property="user"/>
											<TR class="tr3">
												<TD width="5%">
													&nbsp;
												</TD>
												<TH align="left">
													<IMG src="image/board.gif">
													<A
														href="tip.do?op=toTopicList&page=1&board.boardId=<bean:write name='board' property='boardId'/>"><bean:write name='board' property='boardName'/></A>
												</TH>
												<TD align="center">
													<bean:write name="mainBoard" property="topicCount" />
												</TD>
												<TH>
													<SPAN> <A
														href="tip.do?op=toTopicDetail&page=1&board.boardId=<bean:write name='board' property='boardId'/>&topicId=<bean:write name='topic' property='topicId'/>">
													</A> </SPAN>
													<A
														href="tip.do?op=toTopicList&page=1&board.boardId=<bean:write name='board' property='boardId'/>&topicId=<bean:write name='topic' property='topicId'/>"><SPAN><bean:write name='topic' property='title'/></SPAN> </A>
													<BR />
													<SPAN><bean:write name="user" property="userName"/></SPAN>
													<SPAN class="gray">[<bean:write name="topic" property="publishTime" format="yyyy-MM-dd HH:mm:ss"/>]</SPAN>
												</TH>
											</TR>
								</logic:notEqual>							
							</logic:iterate>
					</TABLE>
				</DIV>

				<BR />
				<%@include file="pagefooter.jsp"%>
			</div>
		</center>
	</BODY>
</html>

