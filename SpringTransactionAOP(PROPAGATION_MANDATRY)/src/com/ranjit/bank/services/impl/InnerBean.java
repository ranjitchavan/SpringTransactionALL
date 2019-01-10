package com.ranjit.bank.services.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ranjit.bank.bean.Account;

@Component("innerBean")
public class InnerBean {
	
	@Transactional(transactionManager="dstx",isolation=Isolation.READ_COMMITTED,propagation=Propagation.NEVER,timeout=20,rollbackFor=RuntimeException.class)
	public void transaferMoneyDeducation(Account fromAccount, Account toAccount, double amount) {
		
		
		throw new RuntimeException("SUCCCCCCCCCCCCCCCCCCCCCCCCCC");
	}
}
