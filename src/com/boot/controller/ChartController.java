package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.boot.entity.Orders;
import com.boot.entity.Views;
import com.boot.service.OrdersService;
import com.boot.service.ViewsService;
import com.boot.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/chart", produces = "text/plain;charset=utf-8")
public class ChartController extends BaseController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private ViewsService viewsService;

	@RequestMapping("preBar.action")
	public String preBar() {
		List<Views> viewsList = this.viewsService.getAllViews();
		this.getRequest().setAttribute("viewsList", viewsList);
		return "admin/chartbar";
	}

	@RequestMapping("chartbar.action")
	@ResponseBody
	public String chartbar() throws JSONException {
		String start = this.getRequest().getParameter("start");
		String end = this.getRequest().getParameter("end");
		String id = this.getRequest().getParameter("id");
		long days = VeDate.getDays(end, start) + 1;
		JSONArray sellcount = new JSONArray();// 定义count存放数值
		JSONArray day = new JSONArray(); // 存放名称
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(start, "" + i);
			double sellTotal = 0;
			Orders orders = new Orders();
			orders.setViewsid(id);
			orders.setAddtime(nxtDay);
			List<Orders> sellList = this.ordersService.getOrdersByCond(orders);
			for (Orders s : sellList) {
				sellTotal += Double.parseDouble(s.getNum());
			}
			sellcount.add(sellTotal);
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("count", sellcount.toString());
		json.put("names", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}
}
