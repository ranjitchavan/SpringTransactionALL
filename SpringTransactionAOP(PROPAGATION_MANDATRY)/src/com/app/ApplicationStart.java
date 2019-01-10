package com.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranjit.bank.bean.Account;
import com.ranjit.bank.services.BankServices;

public class ApplicationStart {
  public static void main(String[] args) {
	try(ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application.xml")){
		
		BankServices bs=context.getBean("bankService",BankServices.class);
		bs.transaferMoney(new Account("1111","Ranjit"),new Account("2222","PK"), 100);
	
	}
}
}
