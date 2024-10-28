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
			旅游线路信息
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">所有旅游线路分类</div>
				<dl class="clearfix" style="overflow: hidden;">
					<c:forEach items="${cateList}" var="cate">
						<div class="box1 cate" id="cate">
							<h1 style="border-top: none">
								<a href="index/cate.action?id=${cate.cateid }" class="  f_l">${cate.catename }</a>
							</h1>
						</div>
						<div style="clear: both"></div>
					</c:forEach>
				</dl>
			</div>
			<div class="blank"></div>
			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>热门线路</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotlinesList}" var="lines">
							<ul class="clearfix">
								<li class="goodsimg"><a href="index/detail.action?id=${lines.linesid }" target="_blank"><img
										src="${lines.image }" alt="${lines.linesname }" class="B_blue" /> </a></li>
								<li><a href="index/detail.action?id=${lines.linesid }" target="_blank" title="${lines.linesname }">${lines.linesname }</a>
								</li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>线路列表</span>
					</h3>
					<div class="clearfix goodsBox" style="border: none;">
						<c:forEach items="${linesList}" var="lines">
							<div class="goodsItem" style="padding: 10px 3px 15px 2px;">
								<a href="index/linesdetail.action?id=${lines.linesid }"><img src="${lines.image }" alt="${lines.linesname }"
									class="goodsimg" /> </a> <br />
								<p class="f1">
									<a href="index/detail.action?id=${lines.linesid }" title="${lines.linesname }">${lines.linesname }</a>
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
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
