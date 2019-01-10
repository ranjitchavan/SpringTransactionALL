package com.ranjit.bank.dao;

import com.ranjit.bank.bean.Account;

public interface DepositeDAO {
	public boolean depositeAmount(Account fromAccount,double amount);
	
}
