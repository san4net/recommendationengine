package com.apple.recommendation.service;

import java.util.List;

import com.apple.recommendation.model.UserDetail;

public interface RecommendationRule extends Comparable<RecommendationRule> {
 
	List<UserDetail> apply(List<UserDetail> users, UserDetail user);
	
	int rank();
	
 
	@Override
	default int compareTo(RecommendationRule o) {
		return Integer.compare(rank(), o.rank());
	}
}
