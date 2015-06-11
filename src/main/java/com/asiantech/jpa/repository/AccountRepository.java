package com.asiantech.jpa.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asiantech.jpa.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>, AccountRepositoryCustom {
	List<Account> findByName(int size, Pageable pagable);
}
