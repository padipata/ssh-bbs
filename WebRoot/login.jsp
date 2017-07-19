<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>论坛登录</title>
		<meta http-equiv="content-type" content="text/html; charset=GBK">
		<link rel="stylesheet" type="text/css" href="style/style.css">
		<style type="text/css">
			table {
				font-size: "12px";
			}
		</style>
	</head>

	<BODY>
		<center>
			<div id="content">
				<DIV id="header">
					<img src="image/logo.gif" width="100%" height="100%" />
				</DIV>
				<%@include file="pageheader.jsp"%>
				<div style="height: auto; width: 600px;">
					<FORM name="loginForm" action="user.do?op=doLogin" method="post" >
						<table class="t" style="width: 100%">
							<tr>
								<td align="right"
									style="width: 40%; font-family: ' 宋体; white-space: pre;">
									用户名：
								</td>
								<td style="width: 50%" align="left">
									<INPUT class="input" tabIndex="1" type="text" maxLength="20"
										size="20" id="userName" name="userName" onblur="checkName()"
										value="pjh" style="width: 200px;">
								</td>
							</tr>
							<tr>
								<td align="right"
									style="width: 40%; font-family: ' 宋体; white-space: pre;">
									密&nbsp;&nbsp;码：
								</td>
								<td style="width: 50%" align="left">
									<INPUT class="input" tabIndex="2" type="password"
										maxLength="20" size="20" id="userPwd" name="userPwd" style="width: 200px;"
										value="123">
								</td>
							</tr>
							<tr>
							<html:errors property="LoginInfo"/>
								<td colspan="2" align="center">
									<INPUT class="btn" tabIndex="16" type="submit" value="登 录">&nbsp;&nbsp;
									<INPUT class="btn" tabIndex="16" type="reset" value="重 置">
								</td>
							</tr>
						</table>
					</FORM>
				</div>
				<%@include file="pagefooter.jsp"%>
			</div>
		</center>
	</body>
</html>
