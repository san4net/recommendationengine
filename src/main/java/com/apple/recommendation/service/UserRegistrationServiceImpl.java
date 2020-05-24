package com.apple.recommendation.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.apple.recommendation.model.UserDetail;

@Service
@Configuration
public class UserRegistrationServiceImpl implements UserRegistrationService<UserDetail,String> {
	Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
	
	private Map<String, UserDetail> userStore = new ConcurrentHashMap<String, UserDetail>();

	public boolean add(UserDetail userDetail) throws Exception {
		userStore.put(userDetail.getName(), userDetail);
		logger.info("user {} is added", userDetail.getName());
		return true;
	}

	public UserDetail get(String tradeId) {
		return userStore.get(tradeId);
	}

	@Override
	public Collection<UserDetail> getAll() {
		return userStore.values();
	}


//	@Override
//	public List<String> getRecommendation(String userId, int top) {
//		List<UserDetail> users = userStore.values().stream().filter(u -> {
//			return u.getName() != userId;
//		}).collect(Collectors.toList());
//		
//		 
//		return null;
//	}

}
