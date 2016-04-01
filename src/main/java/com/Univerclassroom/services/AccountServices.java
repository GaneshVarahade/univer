package com.Univerclassroom.services;

import com.Univerclassroom.model.Account;

public interface AccountServices {
	boolean addAccount(Account account) throws Exception;
	Account getAccountById(long Id) throws Exception;
}
