<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="userMenu">
	<a href="index/usercenter.action"><img src="themes/xecmoban_haier2015/images/u2.gif" />用户中心</a>
	<a href="index/userinfo.action"><img src="themes/xecmoban_haier2015/images/u2.gif" />用户信息</a>
	<a href="index/prePwd.action"><img src="themes/xecmoban_haier2015/images/u3.gif" />修改密码</a>
	<a href="index/myfav.action"><img src="themes/xecmoban_haier2015/images/u3.gif" />景点收藏</a>
	<a href="index/prestrategy.action"><img src="themes/xecmoban_haier2015/images/u3.gif" />发布游记</a>
	<a href="index/mystrategy.action"><img src="themes/xecmoban_haier2015/images/u3.gif" />我的游记</a>
	<a href="index/showOrders.action"><img src="themes/xecmoban_haier2015/images/u3.gif" />我的订单</a>
	<a href="index/preComplains.action"><img src="themes/xecmoban_haier2015/images/u3.gif" />意见反馈</a> 
	<a href="index/myComplains.action"><img src="themes/xecmoban_haier2015/images/u3.gif" />我的意见反馈</a>
	<a href="index/exit.action" style="background: none; text-align: right; margin-right: 10px;"> 
	<img src="themes/xecmoban_haier2015/images/bnt_sign.gif" /> </a>
	
</div>
