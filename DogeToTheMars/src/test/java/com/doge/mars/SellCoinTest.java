package com.doge.mars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.doge.mars.dto.CoinDto;
import com.doge.mars.service.DealService;

@SpringBootTest
class SellCoinTest {

	@Autowired
	DealService dealService;

	@Test
	void sellCoinTest() {
		CoinDto coin = new CoinDto();
		coin.setAmount(100);
		coin.setCoinName("name1");
		coin.setUserId("id1");
		dealService.sellCoin(coin);
	}

}
