package com.doge.mars.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.doge.mars.entity.User;

//JpaRepository : findAll, save 같은 메소드를 사용 가능하게 함
public interface UserRepository extends JpaRepository<User, Long> {
	//쿼리가 수행 될 때 authorities정보를 같이 가져오게 됨
	@EntityGraph(attributePaths = "authorities")
	//유저이름(id)로 유저 정보와 권한을 가져옴
	Optional<User> findOneWithAuthoritiesByUsername(String username);
}
