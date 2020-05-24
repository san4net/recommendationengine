package com.apple.recommendation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apple.recommendation.RecommendationService;
import com.apple.recommendation.UserRegistrationService;
import com.apple.recommendation.model.UserDetail;
import com.apple.recommendation.service.ValidationService;



@RestController
public class UserRegisrationController {
	private final Logger log = LoggerFactory.getLogger(UserRegisrationController.class);
	
	@Autowired
	private UserRegistrationService<UserDetail,String> userRegistrationService;
	
	@Autowired
	private ValidationService validationService;
	
	@PostMapping(path="/user/add" , produces="application/json", consumes="application/json")
	public ResponseEntity<String> addUser(@RequestBody UserDetail userDetail) {
		log.info("user details {}", userDetail);
		if(validationService.isValid(userDetail)){
			try {
				userRegistrationService.add(userDetail);
			} catch (Exception e) {
				log.error("error {}", e);
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			return ResponseEntity.ok("success");
		}
		return ResponseEntity.badRequest().body("issue with the request please check request param");
	}
	
	@GetMapping(path="/user/get")
	public ResponseEntity<UserDetail> getUser(String userId) {
		log.info("user details {}", userId);
		UserDetail ud = null;
			try {
				 ud = userRegistrationService.get(userId);
			} catch (Exception e) {
				log.error("error {}", e);
				return ResponseEntity.ok(UserDetail.DUMMY);
			}
			return ResponseEntity.ok(ud);
	}
	
//	@GetMapping("/greeting")
//	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
//	}
	
	
}
