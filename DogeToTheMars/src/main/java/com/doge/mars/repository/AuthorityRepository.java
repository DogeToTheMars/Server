package com.doge.mars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doge.mars.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
