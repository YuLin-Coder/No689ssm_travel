package com.boot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.ViewsDAO;
import com.boot.entity.Views;
import com.boot.service.ViewsService;

@Service("viewsService")
public class ViewsServiceImpl implements ViewsService {
	@Autowired
	private ViewsDAO viewsDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertViews(Views views) {
		return this.viewsDAO.insertViews(views);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateViews(Views views) {
		return this.viewsDAO.updateViews(views);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteViews(String viewsid) {
		return this.viewsDAO.deleteViews(viewsid);
	}

	@Override // 继承接口的查询全部
	public List<Views> getAllViews() {
		return this.viewsDAO.getAllViews();
	}

	@Override // 继承接口的查询全部
	public List<Views> getViewsByNews() {
		return this.viewsDAO.getViewsByNews();
	}

	@Override // 继承接口的查询全部
	public List<Views> getViewsByHot() {
		return this.viewsDAO.getViewsByHot();
	}

	@Override // 继承接口的查询全部
	public List<Views> getViewsByCate(String cateid) {
		return this.viewsDAO.getViewsByCate(cateid);
	}

	@Override // 继承接口的按条件精确查询
	public List<Views> getViewsByCond(Views views) {
		return this.viewsDAO.getViewsByCond(views);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Views> getViewsByLike(Views views) {
		return this.viewsDAO.getViewsByLike(views);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Views getViewsById(String viewsid) {
		return this.viewsDAO.getViewsById(viewsid);
	}

}
