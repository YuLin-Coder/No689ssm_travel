package com.boot.entity;

import com.boot.util.VeDate;

public class Topic {
	private String topicid = "T" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 用户
	private String ordersid;// 订单
	private String viewsid;// 景点
	private String num;// 评分
	private String contents;// 内容
	private String addtime;// 日期
	private String username;// 映射数据
	private String ordercode;// 映射数据
	private String viewsname;// 映射数据

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getOrdersid() {
		return this.ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getViewsid() {
		return this.viewsid;
	}

	public void setViewsid(String viewsid) {
		this.viewsid = viewsid;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
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
		return "Topic [topicid=" + this.topicid + ", usersid=" + this.usersid + ", ordersid=" + this.ordersid
				+ ", viewsid=" + this.viewsid + ", num=" + this.num + ", contents=" + this.contents + ", addtime="
				+ this.addtime + ", username=" + this.username + ", ordercode=" + this.ordercode + ", viewsname="
				+ this.viewsname + "]";
	}

}
