package com.ranjit.bank.services;

import com.ranjit.bank.bean.Account;

public interface BankServices{
	public void transaferMoney(Account fromAccount,Account toAccount,double amount);
}
