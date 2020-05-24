package com.apple.recommendation.service;

import java.util.List;
/**
 * 
 * @author santoshkumar
 *
 * @param <T>
 */
public interface RecommendationService<T,S> {
	
	public void addRule(RecommendationRule rule) ;

	public List<String> getRecommendation(String userId, int top);
	
	List<String> applyRule(List<T> users, T u, int num);

}
