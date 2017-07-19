<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK" import="bbs.biz.*,bbs.entity.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"  %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<DIV class="h">
	&nbsp;&nbsp;
	
	<logic:present name="LoginedUser" scope="session">
	<a href="index.jsp" class="A">首页</a> | 您好:<bean:write name="LoginedUser" property="userName" scope="session"/>欢迎您！
	|&nbsp;
	<a href="user.do?op=doLoginout">注销 </a>
	</logic:present>
	
	<logic:notPresent name="LoginedUser" scope="session">
	<a href="index.jsp" class="A">首页</a> | 您还未
	<a href="login.jsp" class="A">登录</a> |
	<a href="register.jsp">注册 </a>	
	</logic:notPresent>	
	
</DIV>