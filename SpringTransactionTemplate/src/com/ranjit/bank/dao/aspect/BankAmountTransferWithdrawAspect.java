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


@Aspect
@Component
public class BankAmountTransferWithdrawAspect {
	Log log=LogFactory.getFactory().getInstance(BankAmountTransferWithdrawAspect.class);
	
	@Pointcut("execution(* com.ranjit.bank.dao.impl.WithdrawDAOImpl.withdrawAmount(..)) within(com.ranjit.bank.services.impl.BankServicesImpl)")
	public void dummy() {}
	
	
	@Before(value="dummy()")
	public void beforeAspectForTransactionCredit(JoinPoint jp) {
		Object[]obj=jp.getArgs();
		Account ac=(Account)obj[0];
		Double amount=(Double)obj[1];
	
		log.info("Amount start credit from account :"+ac.getAccountNo()+" and Amount is :"+amount);
		
		
	}
	
	@After("dummy()")
	public void afterAspectForTransactionCredit(JoinPoint jp) {
		Object[]obj=jp.getArgs();
		Account ac=(Account)obj[0];
		Double amount=(Double)obj[1];
		
		log.info("Amount credit from account :"+ac.getAccountNo()+" and Amount is :"+amount);
		
	}
	
	
	@AfterReturning(value="dummy()",returning="retValue")
	public Object afterReturningAspectForTransactionCredit(JoinPoint jp,Object retValue) {
		boolean ret=Boolean.parseBoolean(String.valueOf(retValue));
		Object[]obj=jp.getArgs();
		Account ac=(Account)obj[0];
		Double amount=(Double)obj[1];
		
		if(ret==false) {
			log.error("Transaction Failed ");
			log.error("Insufficient account state :"+ac.getAccountNo()+" for the Amount :"+amount);
			throw new RuntimeException("Transaction Failed");
		}else {
			return true;
		}
	}
	
	
	
	@AfterThrowing(value="dummy()",throwing="e")
	public Object afterThrowingAspectForTransactionCredit(JoinPoint jp,RuntimeException e) {
		log.error("Transaction Failed internale error");
		throw e;
		
	}
	
}
