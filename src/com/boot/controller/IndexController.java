package com.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.entity.Article;
import com.boot.entity.Bbs;
import com.boot.entity.Cart;
import com.boot.entity.Cate;
import com.boot.entity.Complains;
import com.boot.entity.Fav;
import com.boot.entity.Hist;
import com.boot.entity.Orders;
import com.boot.entity.Rebbs;
import com.boot.entity.Strategy;
import com.boot.entity.Topic;
import com.boot.entity.Users;
import com.boot.entity.Views;
import com.boot.service.ArticleService;
import com.boot.service.BbsService;
import com.boot.service.CartService;
import com.boot.service.CateService;
import com.boot.service.ComplainsService;
import com.boot.service.FavService;
import com.boot.service.HistService;
import com.boot.service.OrdersService;
import com.boot.service.RebbsService;
import com.boot.service.StrategyService;
import com.boot.service.TopicService;
import com.boot.service.UsersService;
import com.boot.service.ViewsService;
import com.boot.util.PageHelper;
import com.boot.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CateService cateService;
	@Autowired
	private ViewsService viewsService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private FavService favService;
	@Autowired
	private HistService histService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ComplainsService complainsService;
	@Autowired
	private BbsService bbsService;
	@Autowired
	private RebbsService rebbsService;
	@Autowired
	private StrategyService strategyService;

	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "旅游网站");
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Views> hotList = this.viewsService.getViewsByHot();
		this.getRequest().setAttribute("hotList", hotList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Cate> cateList = this.cateService.getCateFront();
		List<Cate> frontList = new ArrayList<Cate>();
		for (Cate cate : cateList) {
			List<Views> viewsList = this.viewsService.getViewsByCate(cate.getCateid());
			cate.setViewsList(viewsList);
			frontList.add(cate);
		}
		this.getRequest().setAttribute("frontList", frontList);
		return "users/index";
	}

	// 公告
	@RequestMapping("article.action")
	public String article(String number) {
		this.front();
		List<Article> tempList = this.articleService.getAllArticle();
		PageHelper.getIndexPage(tempList, "article", "article", null, 10, number, this.getRequest());
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	@RequestMapping("views.action")
	public String views(String number) {
		this.front();
		List<Views> tempList = this.viewsService.getAllViews();
		PageHelper.getIndexPage(tempList, "views", "views", null, 12, number, this.getRequest());
		return "users/views";
	}

	@RequestMapping("recommend.action")
	public String recommend(String number) {
		this.front();
		Views views = new Views();
		views.setRecommed("是");
		List<Views> tempList = this.viewsService.getViewsByCond(views);
		PageHelper.getIndexPage(tempList, "views", "recommend", null, 12, number, this.getRequest());
		return "users/views";
	}

	@RequestMapping("query.action")
	public String query(String number) {
		this.front();
		System.out.println(this.getRequest().getParameter("keywords"));
		Views views = new Views();
		views.setViewsname(this.getRequest().getParameter("keywords"));
		List<Views> tempList = this.viewsService.getViewsByLike(views);
		System.out.println(tempList.size());
		this.getRequest().setAttribute("viewsList", tempList);
		return "users/views";
	}

	@RequestMapping("cate.action")
	public String cate(String number, String id) {
		this.front();
		Views views = new Views();
		views.setCateid(id);
		List<Views> tempList = this.viewsService.getViewsByCond(views);
		PageHelper.getIndexPage(tempList, "views", "cate", id, 12, number, this.getRequest());
		return "users/views";
	}

	@RequestMapping("viewsdetail.action")
	public String viewsdetail(String id) {
		this.front();
		Views views = this.viewsService.getViewsById(id);
		views.setHits("" + (Integer.parseInt(views.getHits()) + 1));
		this.getRequest().setAttribute("views", views);
		Topic topic = new Topic();
		topic.setViewsid(id);
		List<Topic> topicList = this.topicService.getTopicByCond(topic);
		this.getRequest().setAttribute("topicList", topicList);
		this.getRequest().setAttribute("tnum", topicList.size());
		if (this.getSession().getAttribute("userid") != null) {
			String userid = (String) this.getSession().getAttribute("userid");
			Hist hist = new Hist();
			hist.setUsersid(userid);
			hist.setViewsid(id);
			List<Hist> histList = this.histService.getHistByCond(hist);
			if (histList.size() == 0) {
				hist.setNum("1");
				this.histService.insertHist(hist);
			}
		}
		return "users/viewsdetail";
	}

	@RequestMapping("strategy.action")
	public String strategy(String number) {
		this.front();
		List<Strategy> tempList = this.strategyService.getAllStrategy();
		PageHelper.getIndexPage(tempList, "strategy", "strategy", null, 12, number, this.getRequest());
		return "users/strategy";
	}

	@RequestMapping("strategydetail.action")
	public String strategydetail(String id) {
		this.front();
		Strategy strategy = this.strategyService.getStrategyById(id);
		strategy.setHits("" + (Integer.parseInt(strategy.getHits()) + 1));
		this.strategyService.updateStrategy(strategy);
		this.getRequest().setAttribute("strategy", strategy);
		return "users/strategydetail";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		return "redirect:/index/userinfo.action";
	}

	// 留言板
	@RequestMapping("bbs.action")
	public String bbs() {
		this.front();
		List<Bbs> bbsList = this.bbsService.getAllBbs();
		this.getRequest().setAttribute("bbsList", bbsList);
		return "users/bbs";
	}

	// 发布留言
	@RequestMapping("addbbs.action")
	public String addbbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Bbs bbs = new Bbs();
		bbs.setAddtime(VeDate.getStringDate());
		bbs.setContents(getRequest().getParameter("contents"));
		bbs.setHits("0");
		bbs.setRepnum("0");
		bbs.setTitle(getRequest().getParameter("title"));
		bbs.setUsersid(userid);
		this.bbsService.insertBbs(bbs);
		return "redirect:/index/bbs.action";
	}

	// 查看留言
	@RequestMapping("readbbs.action")
	public String readbbs() {
		this.front();
		Bbs bbs = this.bbsService.getBbsById(getRequest().getParameter("id"));
		bbs.setHits("" + (Integer.parseInt(bbs.getHits()) + 1));
		this.bbsService.updateBbs(bbs);
		this.getRequest().setAttribute("bbs", bbs);
		Rebbs rebbs = new Rebbs();
		rebbs.setBbsid(bbs.getBbsid());
		List<Rebbs> rebbsList = this.rebbsService.getRebbsByCond(rebbs);
		this.getRequest().setAttribute("rebbsList", rebbsList);
		return "users/readbbs";
	}

	// 回复留言
	@RequestMapping("rebbs.action")
	public String rebbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Rebbs rebbs = new Rebbs();
		rebbs.setAddtime(VeDate.getStringDate());
		rebbs.setContents(getRequest().getParameter("contents"));
		rebbs.setBbsid(getRequest().getParameter("bbsid"));
		rebbs.setUsersid(userid);
		this.rebbsService.insertRebbs(rebbs);
		Bbs bbs = this.bbsService.getBbsById(rebbs.getBbsid());
		bbs.setRepnum("" + (Integer.parseInt(bbs.getRepnum()) + 1));
		this.bbsService.updateBbs(bbs);
		String path = "redirect:/index/readbbs.action?id=" + bbs.getBbsid();
		return path;
	}

	// 添加产品到购物车
	@RequestMapping("addcart.action")
	public String addcart() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setAddtime(VeDate.getStringDateShort());
		cart.setViewsid(getRequest().getParameter("viewsid"));
		cart.setNum(getRequest().getParameter("num"));
		cart.setPrice(getRequest().getParameter("price"));
		cart.setUsersid(userid);
		this.cartService.insertCart(cart);
		return "redirect:/index/cart.action";
	}

	// 查看购物车
	@RequestMapping("cart.action")
	public String cart() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart);
		this.getRequest().setAttribute("cartList", cartList);
		return "users/cart";
	}

	// 删除购物车中的产品
	@RequestMapping("deletecart.action")
	public String deletecart(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.cartService.deleteCart(id);
		return "redirect:/index/cart.action";
	}

	// 结算
	@RequestMapping("checkout.action")
	public String checkout() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart1 = new Cart();
		cart1.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart1);
		if (cartList.size() == 0) {
			this.getRequest().setAttribute("message", "请选购门票");
			return "redirect:/index/cart.action";
		} else {
			for (Cart cart : cartList) {
				// 获取一个1000-9999的随机数 防止同时提交
				String ordercode = "VD" + VeDate.getStringId();
				double total = Double.parseDouble(cart.getPrice()) * Double.parseDouble(cart.getNum());
				Orders orders = new Orders();
				orders.setAddtime(VeDate.getStringDateShort());
				orders.setOrdercode(ordercode);
				orders.setStatus("未付款");
				orders.setTotal("" + VeDate.getDouble(total));
				orders.setUsersid(userid);
				orders.setNum(cart.getNum());
				orders.setPrice(cart.getPrice());
				orders.setViewsid(cart.getViewsid());
				this.ordersService.insertOrders(orders);
				this.cartService.deleteCart(cart.getCartid());
			}

		}
		return "redirect:/index/showOrders.action";
	}

	// 查看订购
	@RequestMapping("showOrders.action")
	public String showOrders(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Orders orders = new Orders();
		orders.setUsersid(userid);
		List<Orders> tempList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getIndexPage(tempList, "orders", "showOrders", null, 10, number, this.getRequest());
		return "users/orderlist";
	}

	// 准备付款
	@RequestMapping("prePay.action")
	public String prePay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/pay";
	}

	// 付款
	@RequestMapping("pay.action")
	public String pay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已付款");
		this.ordersService.updateOrders(orders);
		Views views = this.viewsService.getViewsById(orders.getViewsid());
		views.setSellnum("" + (Integer.parseInt(views.getSellnum()) + Integer.parseInt(orders.getNum())));
		this.viewsService.updateViews(views);
		return "redirect:/index/showOrders.action";
	}

	// 确认收货
	@RequestMapping("over.action")
	public String over(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已收货");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 取消订单
	@RequestMapping("cancel.action")
	public String cancel(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已取消");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 添加收藏
	@RequestMapping("addfav.action")
	public String addfav(Fav fav) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) getRequest().getSession().getAttribute("userid");
		fav.setAddtime(VeDate.getStringDateShort());
		fav.setViewsid(getRequest().getParameter("id"));
		fav.setUsersid(userid);
		this.favService.insertFav(fav);
		return "redirect:/index/myfav.action";
	}

	// 我的收藏
	@RequestMapping("myfav.action")
	public String myfav(String number) {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Fav fav = new Fav();
		fav.setUsersid(userid);
		List<Fav> favList = this.favService.getFavByCond(fav);
		PageHelper.getIndexPage(favList, "fav", "myfav", null, 10, number, this.getRequest());
		return "users/myfav";
	}

	// 删除收藏
	@RequestMapping("deletefav.action")
	public String deletefav() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.favService.deleteFav(this.getRequest().getParameter("id"));
		return "redirect:/index/myfav.action";
	}

	@RequestMapping("preComplains.action")
	public String preComplains() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addComplains";
	}

	@RequestMapping("addComplains.action")
	public String addComplains(Complains complains) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		complains.setAddtime(VeDate.getStringDateShort());
		complains.setStatus("未回复");
		complains.setUsersid(userid);
		this.complainsService.insertComplains(complains);
		return "redirect:/index/preComplains.action";
	}

	@RequestMapping("myComplains.action")
	public String myComplains(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Complains complains = new Complains();
		complains.setUsersid(userid);
		List<Complains> complainsList = this.complainsService.getComplainsByCond(complains);
		PageHelper.getIndexPage(complainsList, "complains", "myComplains", null, 10, number, this.getRequest());
		return "users/myComplains";
	}

	@RequestMapping("preTopic.action")
	public String preTopic(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("orders", orders);
		return "users/addTopic";
	}

	@RequestMapping("addTopic.action")
	public String addTopic(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus("已评价");
		this.ordersService.updateOrders(orders);
		Topic topic = new Topic();
		topic.setAddtime(VeDate.getStringDateShort());
		topic.setUsersid(orders.getUsersid());
		topic.setViewsid(orders.getViewsid());
		topic.setNum(this.getRequest().getParameter("num"));
		topic.setContents(this.getRequest().getParameter("contents"));
		topic.setOrdersid(id);
		this.topicService.insertTopic(topic);
		return "redirect:/index/showOrders.action";
	}

	@RequestMapping("prestrategy.action")
	public String preGoods() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addstrategy";
	}

	@RequestMapping("addStrategy.action")
	public String addGoods(Strategy strategy) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		strategy.setAddtime(VeDate.getStringDateShort());
		strategy.setHits("0");
		strategy.setStatus("待审核");
		strategy.setUsersid(userid);
		this.strategyService.insertStrategy(strategy);
		return "redirect:/index/prestrategy.action";
	}

	@RequestMapping("mystrategy.action")
	public String myStrategy(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Strategy strategy = new Strategy();
		strategy.setUsersid(userid);
		List<Strategy> tempList = this.strategyService.getStrategyByCond(strategy);
		PageHelper.getIndexPage(tempList, "strategy", "myStrategy", null, 10, number, this.getRequest());
		return "users/mystrategy";
	}

	@RequestMapping("deleteStrategy.action")
	public String deleteStrategy(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.strategyService.deleteStrategy(id);
		return "redirect:/index/mystrategy.action";
	}
}
