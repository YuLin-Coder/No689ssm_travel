package com.boot.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.boot.entity.Strategy;

@Service("strategyService")
public interface StrategyService {
	// 插入数据 调用strategyDAO里的insertStrategy配置
	public int insertStrategy(Strategy strategy);

	// 更新数据 调用strategyDAO里的updateStrategy配置
	public int updateStrategy(Strategy strategy);

	// 删除数据 调用strategyDAO里的deleteStrategy配置
	public int deleteStrategy(String strategyid);

	// 查询全部数据 调用strategyDAO里的getAllStrategy配置
	public List<Strategy> getAllStrategy();
	
	public List<Strategy> getHotStrategy();
	
	// 按照Strategy类里面的字段名称精确查询 调用strategyDAO里的getStrategyByCond配置
	public List<Strategy> getStrategyByCond(Strategy strategy);

	// 按照Strategy类里面的字段名称模糊查询 调用strategyDAO里的getStrategyByLike配置
	public List<Strategy> getStrategyByLike(Strategy strategy);

	// 按主键查询表返回单一的Strategy实例 调用strategyDAO里的getStrategyById配置
	public Strategy getStrategyById(String strategyid);

}
