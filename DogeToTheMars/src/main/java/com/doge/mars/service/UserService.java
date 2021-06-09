package com.doge.mars.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doge.mars.dto.UserDto;
import com.doge.mars.entity.Authority;
import com.doge.mars.entity.User;
import com.doge.mars.repository.UserRepository;
import com.doge.mars.util.SecurityUtil;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = new Authority("ROLE_USER");
        //빌더 패턴의 장점
//        Authority authority = Authority.builder()
//                .authorityName("ROLE_USER")
//                .build();

    	
    	User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getNickname(), true, Collections.singleton(authority));
//        User user = User.builder()
//                .username(userDto.getUsername())
//                .password(passwordEncoder.encode(userDto.getPassword()))
//                .nickname(userDto.getNickname())
//                .authorities(Collections.singleton(authority))
//                .activated(true)
//                .build();

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
    	System.out.println(userRepository.findOneWithAuthoritiesByUsername(username));
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }
}
