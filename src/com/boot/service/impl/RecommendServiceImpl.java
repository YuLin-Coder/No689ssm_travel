package com.boot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.HistDAO;
import com.boot.dao.UsersDAO;
import com.boot.dao.ViewsDAO;
import com.boot.entity.Hist;
import com.boot.entity.Users;
import com.boot.entity.Views;
import com.boot.service.RecommendService;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
	@Autowired
	private HistDAO histDAO;
	// 注入DAO对象
	@Autowired
	private ViewsDAO viewsDAO;
	@Autowired
	private UsersDAO usersDAO;
	private String userid = "";
	// 相似用户集合
	private List<List<Object>> similarityUsers = null;
	// 推荐所有景点集合
	private List<String> targetRecommendViews = null;
	// 浏览过景点集合
	private List<String> commentedViews = null;
	// 用户在景点浏览集合中的位置
	private int targetUserIndex = 0;
	// 目标用户浏览过的景点
	private List<String> targetUserCommentedViews = null;

	private String[] views = null;

	@Override
	public List<Views> getRecommend(String userid) {
		this.userid = userid;
		// 建立用户数组 除了当前用户外 随机抽取9个用户
		String[] users = new String[10];
		users[0] = this.userid;
		List<Users> usersList = this.usersDAO.getUsers(this.userid);
		System.out.println("users == > " + usersList.size());
		for (int i = 0; i < 9; i++) {
			int j = i + 1;
			int tbNum = usersList.size();
			if (i < tbNum) {
				users[j] = usersList.get(i).getUsersid();
			} else {
				users[j] = "0";
			}
		}
		List<Views> viewsList = this.viewsDAO.getAllViews();
		this.views = new String[viewsList.size()];
		for (int j = 0; j < viewsList.size(); j++) {
			this.views[j] = viewsList.get(j).getViewsid();
		}
		// 建立浏览二维数组 用户浏览了景点 1 未浏览 0 之后计算用户的相似度
		int[][] allUserViewshist = new int[10][viewsList.size()];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < viewsList.size(); j++) {
				String viewsid = this.views[j];
				Hist hist = new Hist();
				hist.setUsersid(users[i]);
				hist.setViewsid(viewsid);
				List<Hist> histList = this.histDAO.getHistByCond(hist);
				if (histList.size() == 0) {
					allUserViewshist[i][j] = 0;
				} else {
					Hist h = histList.get(0);
					allUserViewshist[i][j] = Integer.parseInt(h.getNum());
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < viewsList.size(); j++) {
				if (j == viewsList.size() - 1) {
					System.out.print(allUserViewshist[i][j]);
				} else {
					System.out.print(allUserViewshist[i][j] + " ,");
				}
			}
			System.out.println("");
		}
		this.targetUserCommentedViews = new ArrayList<String>();
		Hist hist = new Hist();
		hist.setUsersid(this.userid);
		List<Hist> histList = this.histDAO.getHistByCond(hist);
		for (int i = 0; i < histList.size(); i++) {
			// 转换目标用户景点浏览列表
			this.targetUserCommentedViews.add(histList.get(i).getHistid());
		}

		// 计算用户相似度，排序
		this.calcUserSimilarity(allUserViewshist, viewsList.size());
		// 计算景点推荐度，排序
		this.calcRecommendViews(allUserViewshist, viewsList.size());
		// 处理推荐景点列表
		this.handleRecommendViews(allUserViewshist, viewsList.size());
		String rommendId = "";
		for (int i = 0; i < this.targetRecommendViews.size(); i++) {
			String item = this.targetRecommendViews.get(i);
			if (!commentedViews.contains(item)) {
				if (i == this.targetRecommendViews.size() - 1) {
					rommendId += item;
				} else {
					rommendId += item + ",";
				}
			}
		}
		String[] str = rommendId.split(",");
		List<Views> hotList = new ArrayList<Views>();
		List<Views> viewList = new ArrayList<Views>();
		int viewsize = 0;
		if (!"".equals(rommendId)) {
			for (String x : str) {
				Views g = this.viewsDAO.getViewsById(x);
				viewList.add(g);
				hotList.add(g);
			}
			if (hotList.size() < 5) {
				viewsize = 5 - viewList.size();
				List<Views> list = this.viewsDAO.getViewsByHot();
				for (int i = 0; i < viewsize; i++) {
					Views x = list.get(i);
					hotList.add(x);
				}
			} else if (viewList.size() > 5) {
				hotList = new ArrayList<Views>();
				for (int i = 0; i < 5; i++) {
					Views x = viewList.get(i);
					hotList.add(x);
				}
			}
		} else {
			hotList = this.viewsDAO.getViewsByHot();
		}
		return hotList;
	}

	private void calcRecommendViews(int[][] allUserViewshist, int viewsNum) {
		this.targetRecommendViews = new ArrayList<String>();
		List<List<Object>> recommendViews = new ArrayList<List<Object>>();
		List<Object> recommendView = null;
		double recommdRate = 0, sumRate = 0;
		for (int i = 0; i < viewsNum; i++) {
			recommendView = new ArrayList<Object>();
			recommendView.add(i);
			recommdRate = allUserViewshist[Integer.parseInt(similarityUsers.get(0).get(0).toString())][i]
					* Double.parseDouble(similarityUsers.get(0).get(1).toString())
					+ allUserViewshist[Integer.parseInt(similarityUsers.get(1).get(0).toString())][i]
							* Double.parseDouble(similarityUsers.get(1).get(1).toString());
			recommendView.add(recommdRate);
			recommendViews.add(recommendView);
			sumRate += recommdRate;
		}
		System.out.println("sumRate  == > " + sumRate / viewsNum);
		recommendViews = compare(recommendViews);
		for (List<Object> tList : recommendViews) {
			System.out.println(tList.get(1));
		}
		// 大于平均推荐度的景点才有可能被推荐
		for (int i = 0; i < recommendViews.size(); i++) {
			List<Object> item = recommendViews.get(i);
			if (Double.parseDouble(item.get(1).toString()) > sumRate / viewsNum) { // 大于平均推荐度的景点才有可能被推荐
				System.out.println("views == >" + views[Integer.parseInt(item.get(0).toString())]);
				this.targetRecommendViews.add(views[Integer.parseInt(item.get(0).toString())]);
			}
		}
		for (String x : this.targetRecommendViews) {
			System.out.println("x == >" + x);
		}
	}

	/**
	 * 把推荐列表中用户已经浏览过的景点剔除
	 */
	private void handleRecommendViews(int[][] allUserViewshist, int viewsNum) {
		int[] user2hist = new int[viewsNum];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < viewsNum; j++) {
				user2hist[j] = allUserViewshist[i][j];
			}
		}
		commentedViews = new ArrayList<String>();
		for (int i = 0; i < user2hist.length; i++) {
			if (allUserViewshist[0][i] != 0) {
				commentedViews.add(views[i]);
			}
		}
	}

	/**
	 * 获取两个最相似的用户
	 */
	private void calcUserSimilarity(int[][] allUserViewshist, int viewsNum) {
		int[] user2hist = new int[viewsNum];
		List<List<Object>> tmpList = new ArrayList<List<Object>>();
		for (int i = 0; i < 10; i++) {
			if (i == targetUserIndex) {
				for (int j = 0; j < viewsNum; j++) {
					user2hist[j] = allUserViewshist[i][j];
				}
				continue;
			}
			List<Object> userSimilarity = new ArrayList<Object>();
			int[] user1hist = new int[viewsNum];
			for (int j = 0; j < viewsNum; j++) {
				user1hist[j] = allUserViewshist[i][j];

			}
			userSimilarity.add(i);
			userSimilarity.add(calcTwoUserSimilarity(user1hist, user2hist, viewsNum));
			tmpList.add(userSimilarity);
		}
		this.similarityUsers = compare(tmpList);
	}

	/**
	 * 根据用户数据，计算用户相似度
	 * 
	 * @param user1hist
	 * @param user2hist
	 * @return
	 */
	private static double calcTwoUserSimilarity(int[] user1hist, int[] user2hist, int viewsNum) {
		double sum = 0;
		for (int i = 0; i < viewsNum; i++) {
			sum += Math.pow(user1hist[i] - user2hist[i], 2);
		}
		return Math.sqrt(sum);
	}

	/**
	 * 集合排序
	 */
	private static List<List<Object>> compare(List<List<Object>> tmpList) {
		for (int i = 0; i < tmpList.size(); i++) {
			for (int j = 0; j < tmpList.size() - i; j++) {
				List<Object> t1 = tmpList.get(i);
				List<Object> t2 = tmpList.get(j);
				if (Double.parseDouble("" + t1.get(1)) > Double.parseDouble("" + t2.get(1))) {
					List<Object> tmp = new ArrayList<Object>();
					tmp = t1;
					tmpList.set(i, t2);
					tmpList.set(j, tmp);
				}
			}
		}
		return tmpList;
	}

}
