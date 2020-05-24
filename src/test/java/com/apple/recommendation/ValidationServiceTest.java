package com.apple.recommendation;

import static org.mockito.Mockito.reset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apple.recommendation.controller.UserRegisrationController;
import com.apple.recommendation.model.Gender;
import com.apple.recommendation.model.Interest;
import com.apple.recommendation.model.UserDetail;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValidationServiceTest {
	@Autowired
	private UserRegisrationController tradeStoreController;
	
	@Autowired
	private RecommendationService<UserDetail, String> tradeStoreService;
	
	private UserDetail ud  = UserDetail.builder()
			.name("santi")
			.age(22)
			.gender(Gender.MALE)
			.interest(Sets.newSet(Interest.Football))
			.build();
	
	private UserDetail mockTrade = Mockito.mock(UserDetail.class);
	
	@BeforeEach
	void setUp() throws Exception {
		reset(mockTrade);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	@Order(1)
//	void testVersionValidationFail() {
//		tradeStoreController.addTrade(trade);
//		Mockito.when(mockTrade.getTradeId()).thenReturn(trade.getTradeId());
//		Mockito.when(mockTrade.getVersion()).thenReturn(trade.getVersion()-1);
//		
//		assertThrows(InvalidVersion.class, () -> {
//			tradeStoreController.addTrade(mockTrade);
//		});
//	}
//	
//	@Test
//	@Order(2)
//	void testMaturityFail() {
//		Mockito.when(mockTrade.getTradeId()).thenReturn(trade.getTradeId());
//		Mockito.when(mockTrade.getVersion()).thenReturn(trade.getVersion()+1);
//		Mockito.when(mockTrade.getMaturityDate()).thenReturn(plusDay(-1));
//		assertThrows(RuntimeException.class, () -> {
//			tradeStoreController.addTrade(mockTrade);
//		});
//	}
//	
//	@Test
//	@Order(3)
//	void testVersionValidationPass() {
//		Mockito.when(mockTrade.getTradeId()).thenReturn(trade.getTradeId());
//		Mockito.when(mockTrade.getVersion()).thenReturn(trade.getVersion()+1);
//		Mockito.when(mockTrade.getMaturityDate()).thenReturn(trade.getMaturityDate());
//		assertDoesNotThrow(()->tradeStoreController.addTrade(mockTrade));
//	}
//	
//	@Test
//	@Order(4)
//	void testExpiredTrade() {
//		UserDetail t = tradeStoreService.get(trade.getTradeId());
//		t.setMaturityDate(plusDay(-1));
//		RecommendationServiceImpl temp = (RecommendationServiceImpl) tradeStoreService;
//		temp.markExpired();
//		
//		Mockito.when(mockTrade.getTradeId()).thenReturn(trade.getTradeId());
//		Mockito.when(mockTrade.getVersion()).thenReturn(trade.getVersion()+1);
//		Mockito.when(mockTrade.getMaturityDate()).thenReturn(plusDay(1));
//		assertThrows(RuntimeException.class, ()->tradeStoreController.addTrade(mockTrade));
//	}
	

}
