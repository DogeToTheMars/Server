package com.doge.mars.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doge.mars.dto.CoinDto;
import com.doge.mars.dto.CoinResultDto;
import com.doge.mars.service.DealService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
public class DealController {
	// deal service
	@Autowired
	DealService dealService;
	
	final String SECRET_KEY ="c2lsdmVybmluZS10ZWNoLXNwcmluZy1ib290LWp3dC10dXRvcmlhbC1zZWNyZXQtc2lsdmVybmluZS10ZWNoLXNwcmluZy1ib290LWp3dC10dXRvcmlhbC1zZWNyZXQK";

	@PostMapping(value = "/buy")
	public ResponseEntity<Integer> buyCoin(@RequestBody CoinDto coinDto, HttpServletRequest request) {
		//헤더로 넘어온 토큰 정보를 저장
		String token = request.getHeader("Authorization").substring(7);
		
//		System.out.println(token);
		
		//토큰 body에 있는 claims를 저장
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
		
		//userid라는 이름의 claim을 저장
		String username = (String) claims.get("userid");
//		System.out.println(username);
		coinDto.setUserId(username);
		// 필요한 데이터 : 유저ID, 구매 코인이름, 구매 코인 양
		dealService.buyCoin(coinDto);

		return ResponseEntity.ok(1);
	}
	
	@PostMapping(value = "/sell")
	public ResponseEntity<Integer> sellCoin(@RequestBody CoinDto coinDto, HttpServletRequest request) {
		//헤더로 넘어온 토큰 정보를 저장
		String token = request.getHeader("Authorization").substring(7);
		
//		System.out.println(token);
		
		//토큰 body에 있는 claims를 저장
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
		
		//userid라는 이름의 claim을 저장
		String username = (String) claims.get("userid");
//		System.out.println(username);
		coinDto.setUserId(username);
		// 필요한 데이터 : 유저ID, 구매 코인이름, 구매 코인 양
		dealService.sellCoin(coinDto);
		
		return ResponseEntity.ok(1);
	}
	
	@GetMapping(value ="/list")
	public ResponseEntity<CoinResultDto> getCoinList(HttpServletRequest request){
		String token = request.getHeader("Authorization").substring(7);
		
//		System.out.println(token);
		
		//토큰 body에 있는 claims를 저장
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
		
		//userid라는 이름의 claim을 저장
		String username = (String) claims.get("userid");
		
		System.out.println(username);
		
		CoinResultDto resultDto = new CoinResultDto();
		
		List<CoinDto> list = dealService.getCoinList(username);
		
		System.out.println(list.size());
		
		resultDto.setList(dealService.getCoinList(username));
		
		return ResponseEntity.ok(resultDto);
	}

}
