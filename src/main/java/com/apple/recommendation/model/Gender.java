package com.apple.recommendation.model;

public enum Gender {
 MALE, FEMALE;

	public Gender opposite() {
		return this == MALE ? FEMALE : MALE;
	}
}
