package com.ranjit.bank.dao;

import com.ranjit.bank.bean.Account;

public interface BankAmountTransfer {
	public boolean debitAmount(Account fromAccount,double amount);
	public boolean creditAmount(Account toAccount,double amount);
}
