package com.doge.mars.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.doge.mars.entity.User;
import com.doge.mars.repository.UserRepository;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	// 로그인시에 DB에서 유저정보를 권한 정보와 함께 가져옴
	public UserDetails loadUserByUsername(final String username) {
		return userRepository.findOneWithAuthoritiesByUsername(username).map(user -> createUser(username, user))
				.orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
	}

	private org.springframework.security.core.userdetails.User createUser(String username, User user) {
		if (!user.isActivated()) {
			throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
		}
		// DB에서 해당 유저가 활성화 상태이면 권한정보를 가져옴
		List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
				.collect(Collectors.toList());

		// 유저이름, 패스워드, 권한정보로 user객체를 만들어서 리턴
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}
}
