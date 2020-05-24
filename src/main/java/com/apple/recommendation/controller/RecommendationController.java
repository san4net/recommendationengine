package com.apple.recommendation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apple.recommendation.RecommendationService;
import com.apple.recommendation.model.UserDetail;
import com.google.common.collect.Lists;

@RestController
public class RecommendationController {
	private final Logger log = LoggerFactory.getLogger(RecommendationController.class);

	@Autowired
	private RecommendationService<UserDetail, String> recommendationService;

	@GetMapping(path = "/user/recommend")
	public ResponseEntity<List<String>> getRecommendation(String userId, int top) {
		log.info("user details {}", userId);
		List<String> ud = null;
		try {
			ud = recommendationService.getRecommendation(userId, top);
		} catch (Exception e) {
			log.error("error {}", e);
			return ResponseEntity.ok(Lists.newArrayList());
		}
		return ResponseEntity.ok(ud);
	}

}
