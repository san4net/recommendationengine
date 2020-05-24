package com.apple.recommendation;

import java.util.List;

import com.apple.recommendation.exception.InvalidVersion;
import com.apple.recommendation.exception.TradeNotFoundException;
import com.apple.recommendation.model.UserDetail;
import com.apple.recommendation.service.RecommendationRule;
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
