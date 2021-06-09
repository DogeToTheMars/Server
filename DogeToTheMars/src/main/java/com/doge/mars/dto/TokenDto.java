package com.doge.mars.dto;

import lombok.*;

//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class TokenDto {
	
	

    public TokenDto(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private String token;
}
