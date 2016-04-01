package com.Univerclassroom.dao;

import org.hibernate.annotations.Proxy;

import com.Univerclassroom.model.Account;

@Proxy(lazy=false)
public interface AccountDao {
	boolean addAccount(Account account) throws Exception;
	Account getAccountById(long Id) throws Exception;
}
