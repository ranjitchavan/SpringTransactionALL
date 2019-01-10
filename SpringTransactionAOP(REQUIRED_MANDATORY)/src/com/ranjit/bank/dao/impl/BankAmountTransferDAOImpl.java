package com.ranjit.bank.dao.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ranjit.bank.bean.Account;
import com.ranjit.bank.dao.BankAmountTransfer;

@Repository("bankTransaferDao")
public class BankAmountTransferDAOImpl implements BankAmountTransfer {
	@Autowired(required=true)
	private NamedParameterJdbcTemplate jdbc;
	
	private final static String UPDATE_FROM_ACCOUNT="UPDATE BANK_ACCOUNT SET AMOUNT=AMOUNT-:amount WHERE ACCOUNT_NO=:account_no";
	private final static String UPDATE_TO_ACCOUNT="UPDATE BANK_ACCOUNT SET AMOUNT=AMOUNT+:amount WHERE ACCOUNT_NO=:account_no";
	
	@Override
	public boolean debitAmount(Account fromAccount, double amount) {
		// TODO Auto-generated method stub
		
		MapSqlParameterSource m=new MapSqlParameterSource();
		m.addValue("amount",amount);
		m.addValue("account_no", fromAccount.getAccountNo());
		return jdbc.update(UPDATE_FROM_ACCOUNT,m)!=0;
		
	}

	@Override
	public boolean creditAmount(Account toAccount, double amount) {
		// TODO Auto-generated method stub
		MapSqlParameterSource m=new MapSqlParameterSource();
		m.addValue("amount",amount);
		m.addValue("account_no", toAccount.getAccountNo());
		return jdbc.update(UPDATE_TO_ACCOUNT,m)!=0;
	}
	
}
