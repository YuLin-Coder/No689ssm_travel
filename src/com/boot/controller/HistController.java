package com.boot.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.entity.Hist;
import com.boot.entity.Users;
import com.boot.entity.Views;
import com.boot.service.HistService;
import com.boot.service.UsersService;
import com.boot.service.ViewsService;
import com.boot.util.PageHelper;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/hist" , produces = "text/plain;charset=utf-8")
public class HistController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private HistService histService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private ViewsService viewsService;

	// 准备添加数据
	@RequestMapping("createHist.action")
	public String createHist() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Views> viewsList = this.viewsService.getAllViews();
		this.getRequest().setAttribute("viewsList", viewsList);
		return "admin/addhist";
	}
	// 添加数据
	@RequestMapping("addHist.action")
	public String addHist(Hist hist) {
		this.histService.insertHist(hist);
		return "redirect:/hist/createHist.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteHist.action")
	public String deleteHist(String id) {
		this.histService.deleteHist(id);
		return "redirect:/hist/getAllHist.action";
	}

	// 批量删除数据
	@RequestMapping("deleteHistByIds.action")
	public String deleteHistByIds() {
		String[] ids = this.getRequest().getParameterValues("histid");
		for (String histid : ids) {
			this.histService.deleteHist(histid);
		}
		return "redirect:/hist/getAllHist.action";
	}

	// 更新数据
	@RequestMapping("updateHist.action")
	public String updateHist(Hist hist) {
		this.histService.updateHist(hist);
		return "redirect:/hist/getAllHist.action";
	}

	// 显示全部数据
	@RequestMapping("getAllHist.action")
	public String getAllHist(String number) {
		List<Hist> histList = this.histService.getAllHist();
		PageHelper.getPage(histList, "hist", null, null, 10, number, this.getRequest(), null);
		return "admin/listhist";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryHistByCond.action")
	public String queryHistByCond(String cond, String name, String number) {
		Hist hist = new Hist();
		if(cond != null){
			if ("usersid".equals(cond)) {
				hist.setUsersid(name);
			}
			if ("viewsid".equals(cond)) {
				hist.setViewsid(name);
			}
			if ("num".equals(cond)) {
				hist.setNum(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.histService.getHistByLike(hist), "hist", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryhist";
	}

	// 按主键查询数据
	@RequestMapping("getHistById.action")
	public String getHistById(String id) {
		Hist hist = this.histService.getHistById(id);
		this.getRequest().setAttribute("hist", hist);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Views> viewsList = this.viewsService.getAllViews();
		this.getRequest().setAttribute("viewsList", viewsList);
		return "admin/edithist";
	}


}
