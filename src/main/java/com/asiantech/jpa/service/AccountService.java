package com.asiantech.jpa.service;

import java.util.List;

import com.asiantech.jpa.entity.Account;

public interface AccountService {
	public static String NAME = "accountService";
    public void setMsg(String msg);
    public String getMsg();
	public List<Account> getLimitAccount(int limit,int offset);
	public long getTotalAll();
	public Account create(Account account);
	public Account delete(int id);
	public List<Account> findAll();
	public Account update(Account account);
	public Account findById(int id);

}
