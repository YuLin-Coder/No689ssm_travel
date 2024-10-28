package com.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.entity.Strategy;
import com.boot.entity.Users;
import com.boot.service.StrategyService;
import com.boot.service.UsersService;
import com.boot.util.PageHelper;
import com.boot.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/strategy", produces = "text/plain;charset=utf-8")
public class StrategyController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private StrategyService strategyService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createStrategy.action")
	public String createStrategy() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addstrategy";
	}

	// 添加数据
	@RequestMapping("addStrategy.action")
	public String addStrategy(Strategy strategy) {
		strategy.setUsersid("");
		strategy.setStatus("");
		strategy.setAddtime(VeDate.getStringDateShort());
		strategy.setHits("0");
		this.strategyService.insertStrategy(strategy);
		return "redirect:/strategy/createStrategy.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteStrategy.action")
	public String deleteStrategy(String id) {
		this.strategyService.deleteStrategy(id);
		return "redirect:/strategy/getAllStrategy.action";
	}

	@RequestMapping("audit.action")
	public String audit(String id) {
		Strategy strategy = this.strategyService.getStrategyById(id);
		strategy.setStatus("已审核");
		this.strategyService.updateStrategy(strategy);
		return "redirect:/strategy/getAllStrategy.action";
	}

	// 批量删除数据
	@RequestMapping("deleteStrategyByIds.action")
	public String deleteStrategyByIds() {
		String[] ids = this.getRequest().getParameterValues("strategyid");
		for (String strategyid : ids) {
			this.strategyService.deleteStrategy(strategyid);
		}
		return "redirect:/strategy/getAllStrategy.action";
	}

	// 更新数据
	@RequestMapping("updateStrategy.action")
	public String updateStrategy(Strategy strategy) {
		this.strategyService.updateStrategy(strategy);
		return "redirect:/strategy/getAllStrategy.action";
	}

	// 显示全部数据
	@RequestMapping("getAllStrategy.action")
	public String getAllStrategy(String number) {
		List<Strategy> strategyList = this.strategyService.getAllStrategy();
		PageHelper.getPage(strategyList, "strategy", null, null, 10, number, this.getRequest(), null);
		return "admin/liststrategy";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryStrategyByCond.action")
	public String queryStrategyByCond(String cond, String name, String number) {
		Strategy strategy = new Strategy();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				strategy.setUsersid(name);
			}
			if ("title".equals(cond)) {
				strategy.setTitle(name);
			}
			if ("image".equals(cond)) {
				strategy.setImage(name);
			}
			if ("contents".equals(cond)) {
				strategy.setContents(name);
			}
			if ("status".equals(cond)) {
				strategy.setStatus(name);
			}
			if ("addtime".equals(cond)) {
				strategy.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				strategy.setHits(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.strategyService.getStrategyByLike(strategy), "strategy", nameList, valueList, 10,
				number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querystrategy";
	}

	// 按主键查询数据
	@RequestMapping("getStrategyById.action")
	public String getStrategyById(String id) {
		Strategy strategy = this.strategyService.getStrategyById(id);
		this.getRequest().setAttribute("strategy", strategy);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editstrategy";
	}

	public StrategyService getStrategyService() {
		return strategyService;
	}

	public void setStrategyService(StrategyService strategyService) {
		this.strategyService = strategyService;
	}

}
// 
