package com.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.boot.entity.Views;

@Repository("viewsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface ViewsDAO {

	/**
	 * ViewsDAO 接口 可以按名称直接调用views.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包views.xml里的insertViews配置 返回值0(失败),1(成功)
	public int insertViews(Views views);

	// 更新数据 调用entity包views.xml里的updateViews配置 返回值0(失败),1(成功)
	public int updateViews(Views views);

	// 删除数据 调用entity包views.xml里的deleteViews配置 返回值0(失败),1(成功)
	public int deleteViews(String viewsid);

	// 查询全部数据 调用entity包views.xml里的getAllViews配置 返回List类型的数据
	public List<Views> getAllViews();

	public List<Views> getViewsByNews();

	public List<Views> getViewsByHot();

	public List<Views> getViewsByCate(String cateid);

	// 按照Views类里面的值精确查询 调用entity包views.xml里的getViewsByCond配置 返回List类型的数据
	public List<Views> getViewsByCond(Views views);

	// 按照Views类里面的值模糊查询 调用entity包views.xml里的getViewsByLike配置 返回List类型的数据
	public List<Views> getViewsByLike(Views views);

	// 按主键查询表返回单一的Views实例 调用entity包views.xml里的getViewsById配置
	public Views getViewsById(String viewsid);

}
