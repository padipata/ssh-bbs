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
		<TITLE>广州科贸论坛--帖子列表</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=GBK">
		<Link rel="stylesheet" type="text/css" href="style/style.css" />
	</HEAD>

	<BODY>
	<html:errors property="TipInfo"/>
		<center>
			<div id="content">
				<DIV>
					<IMG src="image/logo.gif" width="100%" height="100">
				</DIV>
				<!--      用户信息、登录、注册        -->

				<%@include file="pageheader.jsp"%>
				<bean:define id="board" name="tipForm" property="board" />
				<bean:define id="topic" name="tipForm" property="topic" />
				<bean:define id="reply" name="tipForm" property="reply" />
				<!--      主体        -->
				<DIV>
					<br />
					<!--      导航        -->
					<DIV id="ww">
						<div style="float: left; padding-top: 6px;">
							&gt;&gt;
							<B><a href="index.jsp">论坛首页</a> </B>&gt;&gt;
							<B><A href="tip.do?op=toTopicList&page=1&board.boardId=<bean:write name='board' property='boardId'/>"><bean:write name='board' property='boardName'/></A>
							</B>&gt;&gt;
							<B><a
								href="tip.do?op=toTopicDetail&page=1&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topic' property='topicId'/>"><bean:write name='topic' property='title'/></a>
							</B>
						</div>

						<!--      回复、新帖        -->
						<logic:present name="LoginedUser" scope="session">
							<DIV align="right" style="float: right">
								<p>
									<A href="tip.do?op=toNewTip&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=-1"><IMG
											src="image/newTopic.gif" name="newTopic" border="0"
											id="newTopic"> </A>
	
									<A href="tip.do?op=toNewTip&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topic' property='topicId'/>"><IMG
											src="image/newReply.gif" name="newTopic" border="0"
											id="newTopic"> </A>
								</p>
							</DIV>
						</logic:present>
						<DIV align="right" style="float: right">
							<logic:notPresent name="LoginedUser" scope="session">
								<p>
									<img alt="newTopic" id="newTopic" name="neiTopic"
										src="image/newTopic.gif"
										onclick="javascript:window.alert('你还未登录，不能发帖')">
	
									<img alt="ReplyTopic" id="ReplyTopic" name="ReplyTopic"
										src="image/newReply.gif"
										onclick="javascript:window.alert('你还未登录，不能回帖')">
	
								</p>
							</logic:notPresent>
						</DIV>
					</DIV>
					<br />

					<!--      本页主题的标题        -->
					<DIV id="ww">
						<TABLE cellSpacing="0" cellPadding="0" width="100%">
							<TR>
								<TH class="h">
									本页主题:<bean:write name="topic" property="title"/>
								</TH>
							</TR>
							<TR class="tr2">
								<TD>
									&nbsp;
								</TD>
							</TR>
						</TABLE>
					</DIV>

					<!--      主题        -->
					<bean:define id="topicUser" name="topicUser" scope="request" />
					<DIV class="t">
						<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed"
							cellSpacing="0" cellPadding="0" width="100%">
							<TR class="tr1">
								<TH style="WIDTH: 20%">
									<B><bean:write name='topicUser' property='userName'/></B>
									<BR />
									<img src="image/heads/<bean:write name='topicUser' property='head'/>" />
									<BR />
									注册:<bean:write name='topicUser' property='regTime' format='yyyy-MM-dd HH:mm:ss'/>
									<BR />
								</TH>
								<TH>
									<H4>
										<bean:write name='topic' property='title'/>
									</H4>
									<DIV>
										<bean:write name='topic' property='content'/>
									</DIV>
									<DIV class="tipad gray" align="right">
										<logic:present name="LoginedUser" scope="session">
											<logic:equal value="${topicUser.userId}" name="LoginedUser" property="userId">
												<A href="tip.do?op=doDeleteTip&board.boardId=<bean:write name='board' property='boardId'/>
												&topic.topicId=<bean:write name='topic' property='topicId'/>
												&reply.replyId=-1">[删除]</A>
											</logic:equal>
										</logic:present>
										发表：[<bean:write name='topic' property='publishTime'/>]
									</DIV>
								</TH>
							</TR>
						</TABLE>
					</DIV>
					<logic:iterate id="replyBean" name="replyList" scope="request">
						<!--      回复       -->
						<DIV class="t">
							<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed"
								cellSpacing="0" cellPadding="0" width="100%">
								<TR class="tr1">
									<TH style="WIDTH: 20%">
										<B><bean:write name="replyBean" property="user.userName"/></B>
										<BR />
										<img src="image/heads/<bean:write name="replyBean" property="user.head"/>" />
										<BR />
										注册:<bean:write name="replyBean" property="user.regTime"/>
										<BR />
									</TH>
									<TH>
										<H4>
											<bean:write name="replyBean" property="reply.title"/>
										</H4>
										<DIV>
											<bean:write name="replyBean" property="reply.content"/>
										</DIV>
										<DIV class="tipad gray" align="right">
										
										<logic:present name="LoginedUser" scope="session">
											<logic:equal value="${topicUser.userId}" name="LoginedUser" property="userId">
												<A href="tip.do?op=doDeleteTip&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topic' property='topicId'/>&reply.replyId=<bean:write name='replyBean' property='reply.replyId'/>">[删除]</A>
												<A href="tip.do?op=toModifyReply&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topic' property='topicId'/>&reply.replyId=<bean:write name='replyBean' property='reply.replyId'/>">[修改]</A>
											</logic:equal>
										</logic:present>
										发表：[<bean:write name='replyBean' property='reply.publishTime'/>] &nbsp;
										最后修改:[<bean:write name='replyBean' property='reply.modifyTime'/>]
										</DIV>
									</TH>
								</TR>
							</TABLE>
						</DIV>
					</logic:iterate>
				</DIV>
				<!--            翻 页          -->
				<DIV align="right">
					<bean:define id="currPage" name="tipForm" property="page"></bean:define>
					<bean:define id="pageCount" name="tipForm" property="pageCount"></bean:define>
					<logic:equal value="1" name="currPage">
						<span style="color: gray;">上一页</span>
					</logic:equal>		
					<logic:greaterThan value="1" name="currPage">
						<A href="tip.do?op=toTopicDetail&page=${currPage-1}&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topic' property='topicId'/>">上一页</A>
					</logic:greaterThan>
					<logic:equal value="${pageCount}" name="currPage">
						<span style="color: gray;">下一页</span>
					</logic:equal>
					<logic:lessThan value="${pageCount}" name="currPage">
						<A href="tip.do?op=toTopicDetail&page=${currPage+1}&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topic' property='topicId'/>">下一页</A>
					</logic:lessThan>
					<span>&nbsp;当前第&nbsp;${currPage}&nbsp;页，共&nbsp;${pageCount}&nbsp;页&nbsp;</span>
				<span><input id=yeshu style="width: 15px" type="text" value="${currPage}" />&nbsp;<input type="button" value="跳转" onclick="tzym()"/> </span>
				<script type="text/javascript">
					function tzym(){
						/*var reg=new RegExp("^[0-9]*$");*/						
						ys = document.getElementById("yeshu").value;
						if(ys>${pageCount} || ys<=0){
							alert("不存在该页面");
							ys = ${currPage};
						}
						window.location.href="tip.do?op=toTopicDetail&page="+ys+"&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topic' property='topicId'/>";
					}
				</script>
				</DIV>
				<!--      声明        -->
				<BR>
				<%@include file="pagefooter.jsp"%>
			</div>
		</center>
	</BODY>
</HTML>