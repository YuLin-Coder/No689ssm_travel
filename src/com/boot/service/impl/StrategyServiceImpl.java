package com.boot.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.StrategyDAO;
import com.boot.entity.Strategy;
import com.boot.service.StrategyService;

@Service("strategyService")
public class StrategyServiceImpl implements StrategyService {
	@Autowired
	@Resource
	private StrategyDAO strategyDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertStrategy(Strategy strategy) {
		return this.strategyDAO.insertStrategy(strategy);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateStrategy(Strategy strategy) {
		return this.strategyDAO.updateStrategy(strategy);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteStrategy(String strategyid) {
		return this.strategyDAO.deleteStrategy(strategyid);
	}

	@Override // 继承接口的查询全部
	public List<Strategy> getAllStrategy() {
		return this.strategyDAO.getAllStrategy();
	}

	public List<Strategy> getHotStrategy() {
		return this.strategyDAO.getHotStrategy();
	}

	@Override // 继承接口的按条件精确查询
	public List<Strategy> getStrategyByCond(Strategy strategy) {
		return this.strategyDAO.getStrategyByCond(strategy);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Strategy> getStrategyByLike(Strategy strategy) {
		return this.strategyDAO.getStrategyByLike(strategy);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Strategy getStrategyById(String strategyid) {
		return this.strategyDAO.getStrategyById(strategyid);
	}

}

// 
