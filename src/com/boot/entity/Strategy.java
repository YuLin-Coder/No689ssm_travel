package com.boot.entity;

import com.boot.util.VeDate;

public class Strategy {
	private String strategyid = "S" + VeDate.getStringId();
	private String usersid;
	private String title;
	private String image;
	private String contents;
	private String status;
	private String addtime;
	private String hits;
	private String username;

	public String getStrategyid() {
		return strategyid;
	}

	public void setStrategyid(String strategyid) {
		this.strategyid = strategyid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
