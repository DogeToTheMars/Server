package com.doge.mars.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DB 테이블과 일대일로 매칭된다는 의미
@Entity
//매칭되는 테이블의 이름
@Table(name = "user")
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class User {

	@JsonIgnore
	//primary key
	@Id
	@Column(name = "user_id")
	//Auto Increasement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "username", length = 50, unique = true)
	private String username;

	@JsonIgnore
	@Column(name = "password", length = 100)
	private String password;

	@Column(name = "tel", length = 50)
	private String tel;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@Column(name = "balance", length = 50)
	private int balance;

	@JsonIgnore
	@Column(name = "activated")
	private boolean activated;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public User(Long userId, String username, String password, String tel, boolean activated,
			Set<Authority> authorities, String email, int balance) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.activated = activated;
		this.authorities = authorities;
		this.balance = balance;
		this.email = email;
	}
	public User(String username, String password, String tel, boolean activated,
			Set<Authority> authorities, String email, int balance) {
		super();
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.activated = activated;
		this.authorities = authorities;
		this.balance = balance;
		this.email = email;
	}
	
	public User() {}


	//테이블간의 일대다, 다대일 관계를 표시
	@ManyToMany
	@JoinTable(name = "user_authority", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_name", referencedColumnName = "authority_name") })
	private Set<Authority> authorities;
}
