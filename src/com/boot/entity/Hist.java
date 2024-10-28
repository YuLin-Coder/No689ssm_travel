package com.boot.entity;

import com.boot.util.VeDate;

public class Hist {
	private String histid = "H" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 用户
	private String viewsid;// 景点
	private String num;// 浏览次数
	private String username;// 映射数据
	private String viewsname;// 映射数据

	public String getHistid() {
		return histid;
	}

	public void setHistid(String histid) {
		this.histid = histid;
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

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
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
		return "Hist [histid=" + this.histid + ", usersid=" + this.usersid + ", viewsid=" + this.viewsid + ", num="
				+ this.num + ", username=" + this.username + ", viewsname=" + this.viewsname + "]";
	}

}
