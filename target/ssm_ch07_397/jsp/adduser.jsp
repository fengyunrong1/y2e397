<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'adduser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <fm:form action="../user/saveuser.do" method="post"  modelAttribute="user">
    	<table>
    		<tr>
    			<td>用户编号：</td>
    			<td><fm:input path="userCode" /></td>
    			<td><fm:errors path="userCode" /></td>
    		</tr>
    		<tr>
    			<td>用户姓名：</td>
    			<td><fm:input path="userName" /></td>
    			<td><fm:errors path="userName" /></td>
    		</tr>
    		<tr>
    			<td>用户密码：</td>
    			<td><fm:password path="userPassword"/> </td>
    			<td><fm:errors path="userPassword"/> </td>
    		</tr>
    		
    		<tr>
    			<td>用户生日：</td>
    			<td><fm:input path="birthday"/></td>
    			<td><fm:errors path="birthday"/></td>
    		</tr>
    		<tr>
    			<td>用户地址：</td>
    			<td><fm:input path="address" /></td>
    			<td><fm:errors path="address" /></td>
    		</tr>
    		<tr>
    			<td>用户电话：</td>
    			<td><fm:input path="phone" /></td>
    			<td><fm:errors path="phone" />  </td>
    		</tr>
    		<tr>
    			<td>角色：</td>
    			<td>
    				<fm:radiobuttons path="userRole" items="${roles }"/>
    			</td>
    			<td></td>
    		</tr>
    		<tr>
    			<td>照片：</td>
    			<td>
    				<input type="file" name="photo" />
    			</td>
    			<td><fm:errors path="photo" /></td>
    		</tr>
    		<tr>
    			<td colspan="3"><input type="submit" value="保存" /> </td>
    		</tr>
    	</table>
    </fm:form>
  </body>
</html>
