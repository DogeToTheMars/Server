package com.doge.mars.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.doge.mars.dto.CoinDto;

@Mapper
public interface DealDao {
	int buyCoin(CoinDto coinDto);
	
	int sellCoin(CoinDto coinDto);
	
	List<CoinDto> getCoinList(String userId);
	
	CoinDto getCoin(CoinDto coinDto);
	
	int deleteCoin(CoinDto coinDto);
	
	int updateCoin(CoinDto coinDto);
}
