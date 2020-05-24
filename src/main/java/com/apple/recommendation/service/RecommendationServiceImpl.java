package com.apple.recommendation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.apple.recommendation.RecommendationService;
import com.apple.recommendation.UserRegistrationService;
import com.apple.recommendation.model.UserDetail;

@Service
@Configuration
public class RecommendationServiceImpl implements RecommendationService<UserDetail,String> {
	Logger logger = LoggerFactory.getLogger(RecommendationServiceImpl.class);
	
	@Autowired
	private UserRegistrationService<UserDetail, String> userRegistration;
	
	List<RecommendationRule> rules = new ArrayList<>();
	
	public void addRule(RecommendationRule rule) {
		rules.add(rule);
	}


	@Override
	public List<String> getRecommendation(String userId, int top) {
		List<UserDetail> users = 
				userRegistration.getAll()
				.stream().
				filter(u -> {
			return u.getName() != userId;
		}).collect(Collectors.toList());
		
		return applyRule(users, userRegistration.get(userId), top);
	}
	
	@PostConstruct
	public void init() {
		addRule(new GenderRule());
		addRule(new InterestRule());
		addRule(new AgeRule());
		Collections.sort(rules);
	}
	
	public List<String> applyRule(List<UserDetail> users, UserDetail u, int num){
		List<UserDetail> filtered = users;
		
		for(RecommendationRule r : rules) {
			filtered = r.apply(filtered, u);
			
			if(filtered.size()<=num) {
				break;
			}
			if(areTopDiferrent(filtered, num, r)) {
				break;
			}
			
		}
		
		if(filtered.size()!=0 && filtered.size()>num) {
			filtered = filtered.subList(0, num);
		}
		
		return filtered.stream().map(UserDetail::getName).collect(Collectors.toList());
	}
	
	private boolean areTopDiferrent(List<UserDetail> users, int top, RecommendationRule rule) {
		int differentCount = 0;

		for (int i = 0; i < users.size() - 2; i++) {
			if (Integer.compare(rule.comparableField(users.get(i)), rule.comparableField(users.get(i + 1))) != 0) {
				differentCount++;
			}
			if (differentCount >= top)
				return true;
		}

		return false;

	}
	
	
	

}
