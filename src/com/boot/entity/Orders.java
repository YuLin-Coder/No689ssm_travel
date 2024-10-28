package com.boot.entity;

import com.boot.util.VeDate;

public class Orders {
	private String ordersid = "O" + VeDate.getStringId();// 生成主键编号
	private String ordercode;// 订单号
	private String usersid;// 用户
	private String viewsid;// 景点
	private String price;// 单价
	private String num;// 数量
	private String total;// 总计
	private String status;// 状态
	private String addtime;// 下单日期
	private String username;// 映射数据
	private String viewsname;// 映射数据

	public String getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getViewsid() {
		return this.viewsid;
	}

	public void setViewsid(String viewsid) {
		this.viewsid = viewsid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getViewsname() {
		return this.viewsname;
	}

	public void setViewsname(String viewsname) {
		this.viewsname = viewsname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Orders [ordersid=" + this.ordersid + ", ordercode=" + this.ordercode + ", usersid=" + this.usersid
				+ ", viewsid=" + this.viewsid + ", price=" + this.price + ", num=" + this.num + ", total=" + this.total
				+ ", status=" + this.status + ", addtime=" + this.addtime + ", username=" + this.username
				+ ", viewsname=" + this.viewsname + "]";
	}

}
