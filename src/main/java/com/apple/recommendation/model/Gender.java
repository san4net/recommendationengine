package com.apple.recommendation.model;

public enum Gender {
 Male, Female;

	public Gender opposite() {
		return this == Male ? Female : Male;
	}
}
