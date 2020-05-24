package com.apple.recommendation.service;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.recommendation.model.UserDetail;

@Service
public class ValidationService {

	
	private Predicate<UserDetail> nameValidator = (UserDetail t)->{
		if(t.getName()==null || t.getName().length()==0) {
			return false;
		}
		return true;
	};
	
	private Predicate<UserDetail> ageValidator = (UserDetail t)->{
		 if(t.getAge()<=0) {
			 return false;
		 }
		return true;
	};
	

	public boolean isValid(UserDetail userDetail) {
		return nameValidator.and(ageValidator).test(userDetail);
	}
	

}
