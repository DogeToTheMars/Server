package com.doge.mars.service;

import java.util.List;

import com.doge.mars.dto.CoinDto;

public interface DealService {
	int buyCoin(CoinDto coinDto);
	
	int sellCoin(CoinDto coinDto);
	
	List<CoinDto> getCoinList(String userId);
}
