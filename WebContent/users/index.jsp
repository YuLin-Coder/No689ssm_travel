<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<base href="<%=basePath%>" />
<title>旅游网站</title>
<link href="themes/xecmoban_haier2015/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="themes/xecmoban_haier2015/js/index.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="clear: both"></div>
	<div id="idTransformView" style="height: 425px; overflow: hidden; position: relative;">
		<ul class="slider" id="idSlider">
			<li><img src="pic/001.jpg" /></li>
			<li><img src="pic/002.jpg" /></li>
			<li><img src="pic/003.jpg" /></li>
			<li><img src="pic/004.jpg" /></li>
		</ul>
		<ul class="num" id="idNum">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>

	<div class="blank5"></div>
	<div class="block clearfix">
		<div class="goodsBox_1">
			<!-- 循环开始  -->
			<c:forEach items="${frontList}" var="cate">
				<div class="xm-box">
					<div class="title">
						<span class="floor-icon"><i></i><b></b> </span>
						<h2>${cate.catename }</h2>
						<a class="more" href="index/views.action">更多</a>
					</div>
					<div id="show_new_area" class="clearfix xm-boxs">
						<!-- 循环开始  -->
						<c:forEach items="${cate.viewsList}" var="views">
							<div class="goodsItem goodsItems">
								<a href="index/viewsdetail.action?id=${views.viewsid }"><img src="${views.image }" alt="${views.viewsname }" class="goodsimg" />
								</a> <br />
								<p class="f1">
									<a href="index/viewsdetail.action?id=${views.viewsid }" title="${views.viewsname }">${views.viewsname }</a>
								</p>
							</div>
						</c:forEach>
						<!-- 循环结束  -->
					</div>
				</div>
				<div class="blank"></div>
			</c:forEach>
			<!-- 循环结束  -->
			<div class="blank"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
