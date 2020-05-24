/**
 * 
 */
package com.apple.recommendation.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.apple.recommendation.model.UserDetail;

/**
 * @author santoshkumar
 *
 */
class UserDetailTest {
	
	private UserDetail ud = null;
	private Date date = Calendar.getInstance().getTime();
	private UserDetail userDetail = Mockito.mock(UserDetail.class);
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ud = UserDetail.builder()
				.name("santi")
				.age(22)
				.gender(Gender.MALE)
				.interest(Sets.newHashSet(Lists.newArrayList(Interest.Football)))
				.build();
	}

	@Test
	void testAllFields() {
		assertEquals("santi", ud.getName());
		assertEquals(22, ud.getAge());
		assertEquals(Gender.MALE, ud.getGender());
		assertEquals(Sets.newHashSet(Lists.newArrayList(Interest.Football)), ud.getInterest());
	}
	

}
