package com.apple.recommendation;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.apple.recommendation.controller.RecommendationController;
import com.apple.recommendation.controller.UserRegisrationController;
import com.apple.recommendation.model.Gender;
import com.apple.recommendation.model.Interest;
import com.apple.recommendation.model.UserDetail;
import com.google.common.collect.Sets;

@SpringBootTest
public class RuleEngineTests {
	@Autowired
	private UserRegisrationController userRegistrationController;
	@Autowired
	private RecommendationController recommendationController;
	
	private UserDetail u1 = newUser("userA", 25, Gender.FEMALE, 
			Sets.newHashSet(Interest.Cricket));
	private UserDetail u2 = newUser("userB", 27, Gender.MALE,
			Sets.newHashSet(Interest.Cricket,
			Interest.Football, 
			Interest.Movies));
	private UserDetail u3 = newUser("userC", 26, Gender.MALE, Sets.newHashSet(
			Interest.Movies, Interest.Tennis, Interest.Cricket, 
			Interest.Football));
	private UserDetail u4 = newUser("userD", 24, Gender.FEMALE, Sets.newHashSet(Interest.Tennis, Interest.Cricket, 
			Interest.Football, Interest.Badminton));
	private UserDetail u5 = newUser("userE", 32, Gender.FEMALE, Sets.newHashSet(Interest.Cricket,
			Interest.Football, 
			Interest.Movies,
			Interest.Badminton));

	@BeforeEach
	public void init() {
		userRegistrationController.addUser(u1);
		userRegistrationController.addUser(u2);
		userRegistrationController.addUser(u3);
		userRegistrationController.addUser(u4);
		userRegistrationController.addUser(u5);
	}
	
	@Test
	public void testUserRecommendation() {
		ResponseEntity<List<String>> res = recommendationController.getRecommendation(u2.getName(), 2);
		System.out.println("got this " + res.getBody());

		assertTrue(res.getBody().contains(u2.getName()));
	}
	
	
	
	public static UserDetail newUser(String name, int age, Gender gender, Set<Interest> interest) {
		return UserDetail.builder()
				.name(name)
				.age(age)
				.gender(gender)
				.interest(interest)
				.build();
	}
	

}
