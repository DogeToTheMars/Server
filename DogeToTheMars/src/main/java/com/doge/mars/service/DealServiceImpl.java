package com.doge.mars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doge.mars.dao.DealDao;
import com.doge.mars.dao.UserDealDao;
import com.doge.mars.dto.CoinDto;
import com.doge.mars.repository.UserRepository;

@Service
public class DealServiceImpl implements DealService{
	
	@Autowired
	DealDao dealDao;
	@Autowired
	UserDealDao userDealDao;
	@Autowired
	UserRepository userRepository;

	@Override
	public int buyCoin(CoinDto coinDto) {
		//여기서 구입 할 수 있는지 확인? 아니면 프론트에서 확인?
		
		//coin테이블에 접근해서 해당 유저의 coin 갯수 amount 만큼 추가
		
//		coinDto.setUserId(SecurityUtil.getCurrentUsername());

		
		CoinDto dto = dealDao.getCoin(coinDto);
		
		if(dto == null) {
			dealDao.buyCoin(coinDto);
		}
		else {
			dealDao.updateCoin(coinDto);
		}
		
		userDealDao.minusUserBalance(coinDto);
		//user 테이블에서 잔액 제거
		return 0;
	}
	
	@Override
	public int sellCoin(CoinDto coinDto) {
		//여기서 구입 할 수 있는지 확인? 아니면 프론트에서 확인?
		
		//coin테이블에 접근해서 해당 유저의 coin 갯수 amount 만큼 추가
		
		CoinDto dto = dealDao.getCoin(coinDto);
		
		if(dto.getAmount() == coinDto.getAmount()) {
			dealDao.deleteCoin(coinDto);
		}
		else {
			dealDao.sellCoin(coinDto);
		}
		
		userDealDao.plusUserBalance(coinDto);
		//user 테이블에서 잔액 추가
		return 0;
	}

	@Override
	public List<CoinDto> getCoinList(String userId) {
		return dealDao.getCoinList(userId);
	}
	
}
