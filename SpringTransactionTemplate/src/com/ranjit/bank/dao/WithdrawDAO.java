package com.ranjit.bank.dao;

import com.ranjit.bank.bean.Account;

public interface WithdrawDAO {
	public boolean withdrawAmount(Account toAccount,double amount);
	
}

