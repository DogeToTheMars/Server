package com.doge.mars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.doge.mars.dto.CoinDto;
import com.doge.mars.service.DealService;

@SpringBootTest
class DogeToTheMarsApplicationTests {
	
	@Autowired
	DealService dealService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void buyCoinTest() {
		CoinDto coin = new CoinDto();
		coin.setAmount(100);
		coin.setCoinName("name1");
		coin.setUserId("id1");
		dealService.buyCoin(coin);
	}

}
