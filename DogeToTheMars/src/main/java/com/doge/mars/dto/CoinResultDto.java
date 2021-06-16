package com.doge.mars.dto;

import java.util.List;

public class CoinResultDto {
	List<CoinDto> list;
	CoinDto coinDto;
	
	public List<CoinDto> getList() {
		return list;
	}
	public void setList(List<CoinDto> list) {
		this.list = list;
	}
	public CoinDto getCoinDto() {
		return coinDto;
	}
	public void setCoinDto(CoinDto coinDto) {
		this.coinDto = coinDto;
	}
}
