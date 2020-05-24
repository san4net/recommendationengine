package com.apple.recommendation.service;

import java.util.List;
import java.util.stream.Collectors;

import com.apple.recommendation.model.UserDetail;
import com.google.common.collect.Sets;

public class InterestRule implements RecommendationRule {
	
	@Override
	public int rank() {
		return 3;
	}

	@Override
	public List<UserDetail> apply(List<UserDetail> users, UserDetail user) {
		return users.stream()
				.sorted((UserDetail a, UserDetail b) -> {
				int aMatch = Sets.intersection(a.getInterest(), user.getInterest()).size();
				int bMatch = Sets.intersection(b.getInterest(), user.getInterest()).size();
			return Integer.compare(bMatch, aMatch);
		})
		.collect(Collectors.toList());

	}
	
	@Override
	public int comparableField(UserDetail user) {
		return user.getInterest().size();
	}	

}
