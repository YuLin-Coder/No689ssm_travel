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
<script type="text/javascript" src="js/views.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>景点管理 <span class="c-gray en">&gt;</span> 编辑景点<a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="views/getViewsById.action?id=${views.viewsid }"
			title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a> &nbsp;&nbsp; &nbsp;<a class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px" href="views/getAllViews.action" title="返回"> <i class="Hui-iconfont">&#xe66b;</i></a>
	</nav>
	<article class="page-container">
		<form class="form form-horizontal" id="form-article-add" action="views/updateViews.action" name="myform" method="post">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">景点名称</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="viewsname" class="input-text" id="viewsname" value="${views.viewsname}" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">景点区域</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"><select name="cateid" class="select" id="cateid"><c:forEach items="${cateList}" var="cate">
								<option value="${cate.cateid}" ${cate.cateid == views.cateid?"selected":"" }>${cate.catename }</option>
							</c:forEach></select></span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">景点图片</label>
				<div class="formControls col-xs-8 col-sm-9">
					<script type="text/javascript" src="js/selimage.js"></script>
					<input class="input-text" type="text" name="image" value="${views.image}" id="image" onclick="selimage();" readonly="readonly" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">门票价格</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="price" class="input-text" id="price" value="${views.price}" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">景点星级</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input name="stars" type="radio" value="1" id="num1" ${views.stars == "1"?"checked":""}/> <img src="themes/xecmoban_haier2015/images/stars1.gif" />
					<input name="stars" type="radio" value="2" id="num2" ${views.stars == "2"?"checked":""}/> <img src="themes/xecmoban_haier2015/images/stars2.gif" />
					<input name="stars" type="radio" value="3" id="num3" ${views.stars == "3"?"checked":""}/> <img src="themes/xecmoban_haier2015/images/stars3.gif" />
					<input name="stars" type="radio" value="4" id="num4" ${views.stars == "4"?"checked":""}/> <img src="themes/xecmoban_haier2015/images/stars4.gif" />
					<input name="stars" type="radio" value="5" id="num5" ${views.stars == "5"?"checked":""}/> <img
						src="themes/xecmoban_haier2015/images/stars5.gif" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">是否推荐</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="radio" name="recommed" value="是" title="是" ${views.recommed == "是"?"checked":""}>是 &nbsp;&nbsp;&nbsp;&nbsp;<input
						type="radio" name="recommed" value="否" title="否" ${views.recommed == "否"?"checked":""}>否
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">景点地址</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="address" class="input-text" id="address" value="${views.address}" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">景点介绍</label>
				<div class="formControls col-xs-8 col-sm-9">
					<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
					<textarea class="textarea" name="contents" id="contents">${views.contents} </textarea>
					<script type="text/javascript">
						CKEDITOR.replace('contents', {
							language : 'zh-cn'
						});
					</script>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<input type="hidden" name="viewsid" id="viewsid" value="${views.viewsid}" /><input type="hidden" name="addtime" id="addtime"
						value="${views.addtime}" /> <input type="hidden" name="hits" id="hits" value="${views.hits}" /> <input type="hidden" name="sellnum"
						id="sellnum" value="${views.sellnum}" /> <input type="hidden" id="basepath" value="<%=basePath%>" />
					<button id="sub" class="btn btn-secondary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i>提交保存
					</button>
					<button id="res" class="btn btn-default radius" type="reset">
						<i class="Hui-iconfont">&#xe68f;</i>取消重置
					</button>
				</div>
			</div>
		</form>
	</article>
</body>
</html>


