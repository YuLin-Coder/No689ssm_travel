package com.boot.entity;

import com.boot.util.VeDate;

public class Fav {
	private String favid = "F" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 用户
	private String viewsid;// 景点
	private String addtime;// 收藏日期
	private String username;// 映射数据
	private String viewsname;// 映射数据

	public String getFavid() {
		return favid;
	}

	public void setFavid(String favid) {
		this.favid = favid;
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
		return "Fav [favid=" + this.favid + ", usersid=" + this.usersid + ", viewsid=" + this.viewsid + ", addtime="
				+ this.addtime + ", username=" + this.username + ", viewsname=" + this.viewsname + "]";
	}

}
