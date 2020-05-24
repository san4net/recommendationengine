package com.apple.recommendation.service;

import java.util.List;
import java.util.stream.Collectors;

import com.apple.recommendation.model.UserDetail;

public class GenderRule implements RecommendationRule {
	
	
	@Override
	public int rank() {
		return 1;
	}

	@Override
	public List<UserDetail> apply(List<UserDetail> users, UserDetail user) {
		return users.stream().filter(u -> {
			return u.getGender() == user.getGender().opposite();
		}).collect(Collectors.toList());
		
	}

}
