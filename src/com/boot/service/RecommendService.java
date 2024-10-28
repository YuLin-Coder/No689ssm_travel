package com.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.entity.Views;

@Service("recommendService")
public interface RecommendService {
	public List<Views> getRecommend(String userid);
}
