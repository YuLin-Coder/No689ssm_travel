<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>旅游网站</title>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index/index.action">首页</a>
			<code> &gt; </code>
			<a href="index/strategy.action">全部游记</a>
			<code> &gt; </code>
			${strategy.title }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block">
		<div class="box">
			<div class="box_1">
				<h3>
					<span>${strategy.title}</span>
				</h3>
				<div class="boxCenterList">
					<center>
						<img src="${strategy.image }" alt="" width="300" height="200" />
					</center>
					${strategy.contents }
				</div>
			</div>
		</div>
		<div class="blank5"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
