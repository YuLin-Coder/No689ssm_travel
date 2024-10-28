<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
			新闻公告
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">

		<div>
			<div class="art_cat_box">
				<table width="100%" border="0" cellpadding="5" cellspacing="0">
					<tr>
						<th style="background: #e5e5e5">文章标题</th>
						<th style="background: #e5e5e5">作者</th>
						<th style="background: #e5e5e5">添加日期</th>
					</tr>
					<c:forEach items="${articleList}" var="article">
						<tr>
							<td><a title="${article.title }" href="index/read.action?id=${article.articleid }"
								style="text-decoration: none" class="f6">${article.title }</a></td>
							<td align="center">管理员</td>
							<td align="center">${article.addtime }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="blank5"></div>
		<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
			<tr>
				<td align="center" bgcolor="#ffffff">${html}</td>
			</tr>
		</table>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
