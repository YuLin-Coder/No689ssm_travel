<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-admin">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>管理员信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="admin/createAdmin.action" data-title="新增管理员" href="javascript:void(0)">新增管理员信息</a></li>
					<li><a data-href="admin/getAllAdmin.action" data-title="管理员列表" href="javascript:void(0)">管理员信息列表</a></li>
					<li><a data-href="admin/queryAdminByCond.action" data-title="管理员查询" href="javascript:void(0)">管理员信息查询</a></li>
					<li><a data-href="admin/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-member">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>用户信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="users/getAllUsers.action" data-title="用户信息列表" href="javascript:void(0)">用户信息列表</a></li>
					<li><a data-href="users/queryUsersByCond.action" data-title="用户信息查询" href="javascript:void(0)">用户信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>新闻公告管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="article/createArticle.action" data-title="新增新闻公告" href="javascript:void(0)">新增新闻公告</a></li>
					<li><a data-href="article/getAllArticle.action" data-title="新闻公告列表" href="javascript:void(0)">新闻公告列表</a></li>
					<li><a data-href="article/queryArticleByCond.action" data-title="新闻公告查询" href="javascript:void(0)">新闻公告查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>景点区域管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="cate/createCate.action" data-title="新增景点区域" href="javascript:void(0)">新增景点区域</a></li>
					<li><a data-href="cate/getAllCate.action" data-title="景点区域列表" href="javascript:void(0)">景点区域列表</a></li>
					<li><a data-href="cate/queryCateByCond.action" data-title="景点区域查询" href="javascript:void(0)">景点区域查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>景点信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="views/createViews.action" data-title="新增景点" href="javascript:void(0)">新增景点信息</a></li>
					<li><a data-href="views/getAllViews.action" data-title="景点列表" href="javascript:void(0)">景点信息列表</a></li>
					<li><a data-href="views/queryViewsByCond.action" data-title="景点查询" href="javascript:void(0)">景点信息查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>游记信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="strategy/getAllStrategy.action" data-title="游记列表" href="javascript:void(0)">游记信息列表</a></li>
					<li><a data-href="strategy/queryStrategyByCond.action" data-title="游记查询" href="javascript:void(0)">游记信息查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>订单信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="orders/getAllOrders.action" data-title="订单列表" href="javascript:void(0)">订单信息列表</a></li>
					<li><a data-href="orders/queryOrdersByCond.action" data-title="订单查询" href="javascript:void(0)">订单信息查询</a></li>
					<li><a data-href="chart/preBar.action" data-title="订单销售统计" href="javascript:void(0)">订单销售统计</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>用户评价管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="topic/getAllTopic.action" data-title="用户评价列表" href="javascript:void(0)">用户评价列表</a></li>
					<li><a data-href="topic/queryTopicByCond.action" data-title="用户评价查询" href="javascript:void(0)">用户评价查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>意见反馈管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="complains/getAllComplains.action" data-title="意见反馈列表" href="javascript:void(0)">意见反馈列表</a></li>
					<li><a data-href="complains/queryComplainsByCond.action" data-title="意见反馈查询" href="javascript:void(0)">意见反馈查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>留言交流管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="bbs/getAllBbs.action" data-title="留言交流列表" href="javascript:void(0)">留言交流列表</a></li>
					<li><a data-href="bbs/queryBbsByCond.action" data-title="留言交流查询" href="javascript:void(0)">留言交流查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>留言回复管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="rebbs/getAllRebbs.action" data-title="留言回复列表" href="javascript:void(0)">留言回复列表</a></li>
					<li><a data-href="rebbs/queryRebbsByCond.action" data-title="留言回复查询" href="javascript:void(0)">留言回复查询</a></li>
				</ul>
			</dd>
		</dl>

	</div>
</aside>


