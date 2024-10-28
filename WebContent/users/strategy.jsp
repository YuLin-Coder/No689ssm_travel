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
			旅游游记
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="box">
			<div class="box_1">
				<h3>
					<span>旅游游记列表</span>
				</h3>
				<div class="clearfix goodsBox" style="border: none;">
					<c:forEach items="${strategyList}" var="strategy">
						<div class="goodsItem" style="padding: 10px 3px 15px 2px;">
							<a href="index/strategydetail.action?id=${strategy.strategyid }"><img src="${strategy.image }"
								alt="${strategy.title }" class="goodsimg" /> </a> <br />
							<p class="f1">
								<a href="index/strategydetail.action?id=${strategy.strategyid }" title="${strategy.title }">${strategy.title }</a>
							</p>
						</div>
					</c:forEach>
				</div>
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
