package com.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.boot.entity.Strategy;

@Repository("strategyDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface StrategyDAO {

	/**
	 * StrategyDAO 接口 可以按名称直接调用strategy.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包strategy.xml里的insertStrategy配置 返回值0(失败),1(成功)
	public int insertStrategy(Strategy strategy);

	// 更新数据 调用entity包strategy.xml里的updateStrategy配置 返回值0(失败),1(成功)
	public int updateStrategy(Strategy strategy);

	// 删除数据 调用entity包strategy.xml里的deleteStrategy配置 返回值0(失败),1(成功)
	public int deleteStrategy(String strategyid);

	// 查询全部数据 调用entity包strategy.xml里的getAllStrategy配置 返回List类型的数据
	public List<Strategy> getAllStrategy();

	public List<Strategy> getHotStrategy();

	// 按照Strategy类里面的值精确查询 调用entity包strategy.xml里的getStrategyByCond配置
	// 返回List类型的数据
	public List<Strategy> getStrategyByCond(Strategy strategy);

	// 按照Strategy类里面的值模糊查询 调用entity包strategy.xml里的getStrategyByLike配置
	// 返回List类型的数据
	public List<Strategy> getStrategyByLike(Strategy strategy);

	// 按主键查询表返回单一的Strategy实例 调用entity包strategy.xml里的getStrategyById配置
	public Strategy getStrategyById(String strategyid);

}
