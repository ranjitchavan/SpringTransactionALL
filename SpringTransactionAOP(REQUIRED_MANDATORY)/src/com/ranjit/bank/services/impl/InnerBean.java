package com.ranjit.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ranjit.bank.bean.Account;
import com.ranjit.bank.dao.BankAmountTransfer;

@Component("innerBean")
public class InnerBean {
	@Autowired(required=true)
	private BankAmountTransfer bankTransaferDao;
	@Transactional(transactionManager="dstx",isolation=Isolation.READ_COMMITTED,propagation=Propagation.MANDATORY,timeout=20,rollbackFor=RuntimeException.class)
	public void transaferMoneyDeducation(Account fromAccount, Account toAccount, double amount) {
		System.out.println("MANDATORY");
		//throw new RuntimeException("my life always ");
		// TODO Auto-generated method stub
				bankTransaferDao.debitAmount(fromAccount, amount);
				bankTransaferDao.creditAmount(toAccount, amount);
	}
}
