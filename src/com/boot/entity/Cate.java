package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import com.boot.util.VeDate;

public class Cate {
	private String cateid = "C" + VeDate.getStringId();// 生成主键编号
	private String catename;// 区域名称
	private String memo;// 备注
	private List<Views> viewsList = new ArrayList<Views>();

	public List<Views> getViewsList() {
		return viewsList;
	}

	public void setViewsList(List<Views> viewsList) {
		this.viewsList = viewsList;
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Cate [cateid=" + this.cateid + ", catename=" + this.catename + ", memo=" + this.memo + "]";
	}

}
