<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>游记管理 <span class="c-gray en">&gt;</span> 游记列表 <a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);"
			title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="9">游记列表</th>
				</tr>
				<tr class="text-c">
					<th class="text-center">发布人</th>
					<th class="text-center">标题</th>
					<th class="text-center">状态</th>
					<th class="text-center">发布日期</th>
					<th class="text-center">点击数</th>
					<th class="text-center">操作</th>
				</tr>
			</thead>
			<c:forEach items="${strategyList}" var="strategy">
				<tr class="text-c">
					<td>${strategy.username}</td>
					<td>${strategy.title}</td>
					<td>${strategy.status}</td>
					<td>${strategy.addtime}</td>
					<td>${strategy.hits}</td>
					<td><c:if test="${strategy.status eq '待审核'}">
							<a href="strategy/audit.action?id=${strategy.strategyid}">通过审核</a>&nbsp;&nbsp;
						</c:if> <a href="strategy/deleteStrategy.action?id=${strategy.strategyid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i
							class="fa fa-trash-o"></i></a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="r">${html } </span>
		</div>
	</div>
</body>
</html>

