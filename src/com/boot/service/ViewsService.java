package com.boot.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.boot.entity.Views;

@Service("viewsService")
public interface ViewsService {
	// 插入数据 调用viewsDAO里的insertViews配置
	public int insertViews(Views views);

	// 更新数据 调用viewsDAO里的updateViews配置
	public int updateViews(Views views);

	// 删除数据 调用viewsDAO里的deleteViews配置
	public int deleteViews(String viewsid);

	// 查询全部数据 调用viewsDAO里的getAllViews配置
	public List<Views> getAllViews();

	public List<Views> getViewsByNews();

	public List<Views> getViewsByHot();

	public List<Views> getViewsByCate(String cateid);

	// 按照Views类里面的字段名称精确查询 调用viewsDAO里的getViewsByCond配置
	public List<Views> getViewsByCond(Views views);

	// 按照Views类里面的字段名称模糊查询 调用viewsDAO里的getViewsByLike配置
	public List<Views> getViewsByLike(Views views);

	// 按主键查询表返回单一的Views实例 调用viewsDAO里的getViewsById配置
	public Views getViewsById(String viewsid);

}
