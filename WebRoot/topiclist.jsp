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
				<bean:define id="board" name="tipForm" property="board"/>
				
				<!--      主体        -->
				<DIV>
					<!--      导航        -->
					<br />
					<DIV align="left">
						<div style="float: left; padding-top: 6px;">
							&gt;&gt;
							<B><a href="index.jsp">论坛首页</a> </B>&gt;&gt;
							<B><A
								href="tip.do?op=toTopicList&page=1&board.boardId=<bean:write name='board' property='boardId'/>">
								<bean:write name='board' property='boardName'/></A>
							</B>
						</div>

						<!--      新帖        -->
						
						<logic:present name="LoginedUser" scope="session">
						<DIV align="right" style="float: right">
							<p>
								<A href="tip.do?op=toNewTip&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=-1">
								<IMG src="image/newTopic.gif" name="newTopic" border="0" id="newTopic"> </A>
							</p>
						</DIV>
						</logic:present>						
						<logic:notPresent name="LoginedUser" scope="session">
						<DIV align="right" style="float: right">
							<p>
								<img alt="newTopic" id="newTopic" name="neiTopic"
									src="image/newTopic.gif"
									onclick="javascript:window.alert('你还未登录，不能发帖')">
							</p>
						</DIV>
						</logic:notPresent>
												
					</DIV>
					<br />

					<DIV class="t">
						<TABLE cellSpacing="0" cellPadding="0" width="100%">
							<TR>
								<TH class="h" style="WIDTH: 100%" colSpan="4">
									<SPAN>&nbsp;</SPAN>
								</TH>
							</TR>
							<!--       表 头           -->
							<TR class="tr2">
								<TD>
									&nbsp;

								</TD>
								<TD style="WIDTH: 80%" align="center">
									文章
								</TD>
								<TD style="WIDTH: 10%" align="center">
									作者
								</TD>
								<TD style="WIDTH: 10%" align="center">
									回复
								</TD>
							</TR>
							<!--         主 题 列 表        -->						
							
						<logic:iterate id="topicBean" name="topicList" scope="request">											
								<TR class="tr3">
								<TD>
									<IMG src="image/topic.gif" border=0>
								</TD>
								<TD style="FONT-SIZE: 15px">
									<A
										href="tip.do?op=toTopicDetail&page=1&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topicBean' property='topic.topicId'/>">
										<bean:write name="topicBean" property="topic.title"/></A>
								</TD>
								<TD align="center">
									<bean:write name="topicBean" property="user.userName"/>
								</TD>
								<TD align="center">
									<bean:write name="topicBean" property="replyCount"/>
								</TD>
							</TR>							
						</logic:iterate>	
						
						</TABLE>
					</DIV>
				</DIV>
				<!--            翻 页          -->
				<DIV align="right">
				<bean:define id="currPage" name="tipForm" property="page"/>
				<bean:define id="pageCount" name="tipForm" property="pageCount"/>
				<logic:equal value="1" name="currPage">
					<span style="color: gray;">上一页</span>				
				</logic:equal>
				
				<logic:greaterThan value="1" name="currPage">
					<a href="tip.do?op=toTopicList&page=${currPage-1}&board.boardId=<bean:write name='board' property='boardId'/>">上一页</a>
				</logic:greaterThan>						
						
				<logic:equal value="${tipForm.pageCount}" name="currPage">
					<span style="color: gray;">下一页</span>
				</logic:equal>			
				
				<logic:lessThan value="${tipForm.pageCount}" name="currPage">
					<a href="tip.do?op=toTopicList&page=${currPage+1}&board.boardId=<bean:write name='board' property='boardId'/>">下一页</a>
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
						window.location.href="tip.do?op=toTopicList&page="+ys+"&board.boardId=<bean:write name='board' property='boardId'/>";
					}
				</script>
				</DIV>
				<!--             声 明          -->
				<BR />
				<%@include file="pagefooter.jsp"%>
			</div>
		</center>

	</BODY>
</HTML>