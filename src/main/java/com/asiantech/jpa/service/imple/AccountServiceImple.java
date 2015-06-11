package com.asiantech.jpa.service.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import  com.asiantech.jpa.repository.AccountRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiantech.jpa.entity.Account;
import com.asiantech.jpa.service.AccountService;
@Service(AccountService.NAME)
public class AccountServiceImple implements AccountService {
	private String msg;
	 public AccountServiceImple(){
		 msg="";
	 }
	@Resource
	private AccountRepository AccountRepository;
	@PersistenceContext
	private EntityManager em;
	@Override
	@Transactional
	public long getTotalAll(){
		 return AccountRepository.getTotalAll();
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Account> getLimitAccount(int limit,int offset){
		return AccountRepository.getLimitAccount(limit, offset);
	}

	@Override
	@Transactional
	public Account create(Account account){
		return AccountRepository.save(account);
	}
	@Override
	public Account delete(int id){	
    Account deletedAccount = AccountRepository.findOne(id);
		AccountRepository.delete(deletedAccount);
		return deletedAccount;
	}
	@Override
	@Transactional
	public List<Account> findAll(){
		return AccountRepository.findAll();
	}
	@Override
	@Transactional
	public Account update(Account account){
     Account updatedAccount = AccountRepository.findOne(account.getId());
	updatedAccount.setName(account.getName());
	updatedAccount.setFirstname(account.getFirstname());
	updatedAccount.setLastname(account.getLastname());
	updatedAccount.setStatus(account.getStatus());
	updatedAccount.setSex(account.isSex());
	return updatedAccount;
		
		
	}
	@Override
	@Transactional
	public Account findById(int id){
		return AccountRepository.findOne(id);
	}
	@Override
	public void setMsg(String msg) {
		this.msg=msg;
	} 
	@Override
	public String getMsg() {
		return msg;
	}
}
