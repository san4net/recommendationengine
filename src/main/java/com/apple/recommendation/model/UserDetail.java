package com.apple.recommendation.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@Builder
public class UserDetail  {
	public static final UserDetail DUMMY = new UserDetail("",Gender.Female,-1,new HashSet());
	private String name;
	private Gender gender;
	private int age;
	Set<Interest> interest;
	
}
