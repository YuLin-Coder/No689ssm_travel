<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="all-help bgc-f2">
	<div class="container clearfix" style="overflow: hidden;"></div>
</div>
<div class="all-footer">
	<div class="container clearfix">
		<p class="p-icp">
			版本所有　｜　<a href="admin/index.action" target="_blank">后台管理员入口</a>
		</p>
	</div>
</div>
<%
	String message = (String) session.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	session.removeAttribute("message");
%>