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
			用户中心
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">
						<h5>
							<span>我的游记</span>
						</h5>
						<div class="blank"></div>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr align="center" bgcolor="#ffffff">
								<td align="center" bgcolor="#ffffff">发布人</td>
								<td align="center" bgcolor="#ffffff">标题</td>
								<td align="center" bgcolor="#ffffff">状态</td>
								<td align="center" bgcolor="#ffffff">发布日期</td>
								<td align="center" bgcolor="#ffffff">点击数</td>
								<td align="center" bgcolor="#ffffff" width="5%">操作</td>
							</tr>
							<c:forEach items="${strategyList}" var="strategy">
								<tr align="center" bgcolor="#ffffff">
									<td align="center" bgcolor="#ffffff">${strategy.username}</td>
									<td align="center" bgcolor="#ffffff">${strategy.title}</td>
									<td align="center" bgcolor="#ffffff">${strategy.status}</td>
									<td align="center" bgcolor="#ffffff">${strategy.addtime}</td>
									<td align="center" bgcolor="#ffffff">${strategy.hits}</td>
									<td align="center" bgcolor="#ffffff"><a href="index/deleteStrategy.action?id=${strategy.strategyid}"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a></td>
								</tr>
							</c:forEach>
						</table>
						<div class="blank5"></div>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr>
								<td align="center" bgcolor="#ffffff">${html}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
