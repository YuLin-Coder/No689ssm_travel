package com.boot.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.entity.Cate;
import com.boot.entity.Views;
import com.boot.service.CateService;
import com.boot.service.ViewsService;
import com.boot.util.PageHelper;
import com.boot.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/views" , produces = "text/plain;charset=utf-8")
public class ViewsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private ViewsService viewsService;
	@Autowired
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createViews.action")
	public String createViews() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/addviews";
	}
	// 添加数据
	@RequestMapping("addViews.action")
	public String addViews(Views views) {
		views.setAddtime(VeDate.getStringDateShort());
		views.setHits("0");
		views.setSellnum("0");
		this.viewsService.insertViews(views);
		return "redirect:/views/createViews.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteViews.action")
	public String deleteViews(String id) {
		this.viewsService.deleteViews(id);
		return "redirect:/views/getAllViews.action";
	}

	// 批量删除数据
	@RequestMapping("deleteViewsByIds.action")
	public String deleteViewsByIds() {
		String[] ids = this.getRequest().getParameterValues("viewsid");
		for (String viewsid : ids) {
			this.viewsService.deleteViews(viewsid);
		}
		return "redirect:/views/getAllViews.action";
	}

	// 更新数据
	@RequestMapping("updateViews.action")
	public String updateViews(Views views) {
		this.viewsService.updateViews(views);
		return "redirect:/views/getAllViews.action";
	}

	// 显示全部数据
	@RequestMapping("getAllViews.action")
	public String getAllViews(String number) {
		List<Views> viewsList = this.viewsService.getAllViews();
		PageHelper.getPage(viewsList, "views", null, null, 10, number, this.getRequest(), null);
		return "admin/listviews";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryViewsByCond.action")
	public String queryViewsByCond(String cond, String name, String number) {
		Views views = new Views();
		if(cond != null){
			if ("viewsname".equals(cond)) {
				views.setViewsname(name);
			}
			if ("cateid".equals(cond)) {
				views.setCateid(name);
			}
			if ("image".equals(cond)) {
				views.setImage(name);
			}
			if ("price".equals(cond)) {
				views.setPrice(name);
			}
			if ("stars".equals(cond)) {
				views.setStars(name);
			}
			if ("recommed".equals(cond)) {
				views.setRecommed(name);
			}
			if ("addtime".equals(cond)) {
				views.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				views.setHits(name);
			}
			if ("sellnum".equals(cond)) {
				views.setSellnum(name);
			}
			if ("address".equals(cond)) {
				views.setAddress(name);
			}
			if ("contents".equals(cond)) {
				views.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.viewsService.getViewsByLike(views), "views", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryviews";
	}

	// 按主键查询数据
	@RequestMapping("getViewsById.action")
	public String getViewsById(String id) {
		Views views = this.viewsService.getViewsById(id);
		this.getRequest().setAttribute("views", views);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editviews";
	}


}
