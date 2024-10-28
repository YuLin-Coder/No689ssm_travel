<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>旅游网站</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="js/ajax.js" charset="utf-8"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index/index.action">首页</a>
			<code> &gt; </code>
			发布游记
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
							<span>发布游记</span>
						</h5>
						<div class="blank"></div>
						<form action="index/addStrategy.action" name="myform" method="post">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">游记标题：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input name="title" type="text" size="25" class="inputBg"
										id="title" placeholder="请输入游记标题" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">图片：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input name="image" type="text" size="25" class="inputBg"
										id="image" onclick="selimage();" placeholder="请选择图片" readonly="readonly" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">游记介绍：</td>
									<td align="left" bgcolor="#FFFFFF"><script type="text/javascript" src="ckeditor/ckeditor.js"></script> <textarea
											cols="80" name="contents" id="contents" rows="10">在此添加内容 </textarea> <script type="text/javascript">
												CKEDITOR.replace('contents', {
													language : 'zh-cn'
												});
											</script></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="hidden" name="id" id="id" value="${id }">
										<input type="submit" class="bnt_blue_1" style="border: none;" value="确认发布" /></td>
								</tr>
							</table>
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
