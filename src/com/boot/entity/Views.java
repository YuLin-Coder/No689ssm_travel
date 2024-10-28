package com.boot.entity;

import com.boot.util.VeDate;

public class Views {
	private String viewsid = "V" + VeDate.getStringId();// 生成主键编号
	private String viewsname;// 景点名称
	private String cateid;// 景点区域
	private String image;// 景点图片
	private String price;// 门票价格
	private String stars;// 景点星级
	private String recommed;// 是否推荐
	private String addtime;// 创建日期
	private String hits;// 点击数
	private String sellnum;// 销售数量
	private String address;// 景点地址
	private String contents;// 景点介绍
	private String catename;// 映射数据

	public String getViewsid() {
		return viewsid;
	}

	public void setViewsid(String viewsid) {
		this.viewsid = viewsid;
	}

	public String getViewsname() {
		return this.viewsname;
	}

	public void setViewsname(String viewsname) {
		this.viewsname = viewsname;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStars() {
		return this.stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getRecommed() {
		return this.recommed;
	}

	public void setRecommed(String recommed) {
		this.recommed = recommed;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getSellnum() {
		return this.sellnum;
	}

	public void setSellnum(String sellnum) {
		this.sellnum = sellnum;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Views [viewsid=" + this.viewsid + ", viewsname=" + this.viewsname + ", cateid=" + this.cateid
				+ ", image=" + this.image + ", price=" + this.price + ", stars=" + this.stars + ", recommed="
				+ this.recommed + ", addtime=" + this.addtime + ", hits=" + this.hits + ", sellnum=" + this.sellnum
				+ ", address=" + this.address + ", contents=" + this.contents + ", catename=" + this.catename + "]";
	}

}
