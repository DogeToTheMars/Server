package com.doge.mars.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authority")
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Authority {
   public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Id
   @Column(name = "authority_name", length = 50)
   private String authorityName;

	public Authority(String authorityName) {
		super();
		this.authorityName = authorityName;
	}
	
	public Authority() {}
}
