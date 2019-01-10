package com.ranjit.bank.dao.aspect;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ranjit.bank.bean.Account;
import com.ranjit.bank.dao.impl.BankAmountTransferDAOImpl;

@Aspect
@Component
public class BankAmountTransferDebitAspect {
	Log log=LogFactory.getFactory().getInstance(BankAmountTransferDebitAspect.class);
	
	@Pointcut("execution(* com.ranjit.bank.dao.impl.BankAmountTransferDAOImpl.debitAmount(..)) within(com.ranjit.bank.services.impl.BankServicesImpl)")
	public void dummy() {}
	
	
	@Before(value="dummy()")
	public void beforeAspectForTransactionDebit(JoinPoint jp) {
		Object[]obj=jp.getArgs();
		Account ac=(Account)obj[0];
		Double amount=(Double)obj[1];
		log.info("Amount start Debit from account :"+ac.getAccountNo()+" and Amount is :"+amount);
		
		
	}
	
	@After("dummy()")
	public void afterAspectForTransactionDebit(JoinPoint jp) {
		Object[]obj=jp.getArgs();
		Account ac=(Account)obj[0];
		Double amount=(Double)obj[1];
		log.info("Amount Debited from account :"+ac.getAccountNo()+" and Amount is :"+amount);
		
	}
	
	@AfterReturning(value="dummy()",returning="retValue")
	public Object afterReturningAspectForTransactionDebit(JoinPoint jp,Object retValue)  {
		boolean ret=Boolean.parseBoolean(String.valueOf(retValue));
		Object[]obj=jp.getArgs();
		Account ac=(Account)obj[0];
		Double amount=(Double)obj[1];
		if(ret==false) {
			log.error("Transaction Failed ");
			log.error("Insufficient amount in account :"+ac.getAccountNo()+" for the Amount :"+amount);
			throw new RuntimeException("Transaction Failed");
		}else {
			return true;
		}
	}
	
	@AfterThrowing(value="dummy()",throwing="e")
	public Object afterThrowingAspectForTransactionDebit(JoinPoint jp,RuntimeException e) {
		log.error("Transaction Failed internale error");
		throw e;
		
	}
	
}
