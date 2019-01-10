package com.ranjit.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ranjit.bank.bean.Account;
import com.ranjit.bank.dao.BankAmountTransfer;
import com.ranjit.bank.services.BankServices;
@Service("bankService")
public class BankServicesImpl implements BankServices{
	@Autowired(required=true)
	private BankAmountTransfer bankTransaferDao;
	@Autowired(required=true)
	private InnerBean innerBean;
	
	
	//
	@Override
	@Transactional(transactionManager="dstx",isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,timeout=20,rollbackFor=RuntimeException.class)
	public void transaferMoney(Account fromAccount, Account toAccount, double amount) {
		
		try {
		//	Thread.sleep(19900);
			
		}catch(Exception e) {
			System.out.println("my code is always s");
			
		}
		
		// TODO Auto-generated method stub
		bankTransaferDao.debitAmount(fromAccount, amount);
		bankTransaferDao.creditAmount(toAccount, amount);
		try {
		innerBean.transaferMoneyDeducation(toAccount,new Account("4","Jack"),5);
		}catch(RuntimeException e) {
			e.printStackTrace();
			System.out.println("BankServicesImpl.transaferMoney() Exception");
		}
		
		
	}
	
	
	
	
}
