package com.asiantech.jpa.repository;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.asiantech.jpa.entity.Account;

public interface AccountRepositoryCustom {
	PageImpl<Account> findByFirstNameAndLastNameContains(String firstName, String lastName, Pageable pageable);
	public List<Account> getLimitAccount(int limit,int offset);
	public long getTotalAll();
}
