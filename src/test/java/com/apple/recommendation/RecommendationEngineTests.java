package com.apple.recommendation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apple.recommendation.controller.RecommendationController;
import com.apple.recommendation.controller.UserRegisrationController;
import com.apple.recommendation.model.Gender;
import com.apple.recommendation.model.Interest;
import com.apple.recommendation.model.UserDetail;
import com.google.common.collect.Sets;

@SpringBootTest
public class RecommendationEngineTests {
	@Autowired
	private UserRegisrationController userRegistrationController;
	
	private UserDetail u1 = newUser("userA", 25, Gender.Female, 
			Sets.newHashSet(Interest.Cricket));
	private UserDetail u2 = newUser("userB", 27, Gender.Male,
			Sets.newHashSet(Interest.Cricket,
			Interest.Football, 
			Interest.Movies));
	private UserDetail u3 = newUser("userC", 26, Gender.Male, Sets.newHashSet(
			Interest.Movies, Interest.Tennis, Interest.Cricket, 
			Interest.Football));
	private UserDetail u4 = newUser("userD", 24, Gender.Female, Sets.newHashSet(Interest.Tennis, Interest.Cricket, 
			Interest.Football, Interest.Badminton));
	private UserDetail u5 = newUser("userE", 32, Gender.Female, Sets.newHashSet(Interest.Cricket,
			Interest.Football, 
			Interest.Movies,
			Interest.Badminton));

	
	@Test
	public void testUserAddition() {
		userRegistrationController.addUser(u1);
		userRegistrationController.addUser(u2);
		userRegistrationController.addUser(u3);
		userRegistrationController.addUser(u4);
		userRegistrationController.addUser(u5);
		assertEquals(u1.getName(), userRegistrationController.getUser(u1.getName()).getBody().getName());
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
