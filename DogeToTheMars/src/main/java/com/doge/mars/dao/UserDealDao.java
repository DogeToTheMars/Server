package com.doge.mars.dao;

import org.apache.ibatis.annotations.Mapper;

import com.doge.mars.dto.CoinDto;

@Mapper
public interface UserDealDao {
	int updateUserBalance(CoinDto coinDto);
	
	int plusUserBalance(CoinDto coinDto);
	
	int minusUserBalance(CoinDto coinDto);
}
