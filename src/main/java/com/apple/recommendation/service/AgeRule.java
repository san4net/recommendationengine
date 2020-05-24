package com.apple.recommendation.service;

import java.util.List;
import java.util.stream.Collectors;

import com.apple.recommendation.model.UserDetail;

public class AgeRule implements RecommendationRule {
	
	@Override
	public int rank() {
		return 2;
	}

	@Override
	public List<UserDetail> apply(List<UserDetail> users, UserDetail user) {
		return users.stream()
				.sorted((UserDetail a, UserDetail b) -> {
			return Integer.compare
					(Math.abs(user.getAge() - a.getAge()), Math.abs(user.getAge() - b.getAge()));
		})
		.collect(Collectors.toList());

	}

}
