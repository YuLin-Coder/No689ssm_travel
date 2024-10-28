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
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index/index.action">首页</a>
			<code> &gt; </code>
			<a href="index/views.action">全部景点</a>
			<code> &gt; </code>
			${views.viewsname }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">所有景点地区</div>
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
						<span>热门景点</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotList}" var="views">
							<ul class="clearfix">
								<li class="goodsimg"><a href="index/viewsdetail.action?id=${views.viewsid }" target="_blank"><img src="${views.image }"
										alt="${views.viewsname }" class="B_blue" /> </a></li>
								<li><a href="index/viewsdetail.action?id=${views.viewsid }" target="_blank" title="${views.viewsname }">${views.viewsname }</a></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>

		<div class="AreaR">
			<div id="goodsInfo" class="clearfix">
				<div class="imgInfo">
					<img src="${views.image}" alt="${views.viewsname }" width="360px;" height="360px" />
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>
				<form action="index/addcart.action" method="post" name="ECS_FORMBUY" id="ECS_FORMBUY">
					<div class="textInfo">
						<h1 class="clearfix">${views.viewsname }</h1>
						<ul class="ul2 clearfix">
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>价格：</strong><font class="shop" id="ECS_SHOPPRICE">￥${views.price }元</font>
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>景点区域：</strong><a href="index/cate.action?id=${views.cateid }"><font color="red">${views.catename }</font></a>
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>景点星级：</strong><img src="themes/xecmoban_haier2015/images/stars${views.stars}.gif" />
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>景点地址：</strong>${views.address}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>点击数：</strong>${views.hits}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>门票销量：</strong>${views.sellnum}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<a href="index/addfav.action?id=${views.viewsid }"><font color="red">收藏景点</font></a>
								</dd>
							</li>
						</ul>
						<ul class="bnt_ul">
							<li class="clearfix">
								<dd>
									<strong>购买数量：</strong> <input name="num" type="text" id="number" value="1" size="4" style="border: 1px solid #ccc;" /> <input
										type="hidden" name="viewsid" value="${views.viewsid }" /> <input type="hidden" name="price" value="${views.price }" />
								</dd>
							</li>
							<li class="padd"><input type="image" src="themes/xecmoban_haier2015/images/goumai2.png" /></li>
						</ul>
					</div>
				</form>
			</div>
			<div class="blank"></div>


			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>景点描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_h">
						<blockquote>${views.contents}</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>
			<div id="ECS_COMMENT">
				<div class="box">
					<div class="box_1">
						<h3>
							<span class="text">用户评论</span>(共<font class="f1">${tnum }</font>条评论)
						</h3>
						<div class="boxCenterList clearfix" style="height: 1%;">
							<ul class="comments">
								<c:forEach items="${topicList}" var="topic">
									<li class="word"><font class="f2">${topic.username }</font> <font class="f3">( ${topic.addtime } )</font><br /> <img
										src="themes/xecmoban_haier2015/images/stars${topic.num }.gif" alt="" />
										<p>${topic.contents }</p></li>
								</c:forEach>
							</ul>
							<div class="blank5"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
			<div class="blank5"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
