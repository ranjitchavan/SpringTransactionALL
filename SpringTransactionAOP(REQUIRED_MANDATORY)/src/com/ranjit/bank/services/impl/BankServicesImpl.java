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
	//@Transactional(transactionManager="dstx",isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,timeout=20,rollbackFor=RuntimeException.class)
	public void transaferMoney(Account fromAccount, Account toAccount, double amount) {
	
		try {
		innerBean.transaferMoneyDeducation(fromAccount,toAccount,amount);
		}catch(RuntimeException e) {
			System.out.println("Exception says every things");
			e.printStackTrace();}
		
		
	}
	
	
	
	
}
