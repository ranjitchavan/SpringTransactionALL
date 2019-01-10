package com.ranjit.bank.dao.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ranjit.bank.bean.Account;
import com.ranjit.bank.dao.DepositeDAO;


@Repository("depositeDao")
public class DepositeDAOImpl implements DepositeDAO {
	@Autowired(required=true)
	private NamedParameterJdbcTemplate oracleJdbc;
	private final static String UPDATE_TO_ACCOUNT="UPDATE BANK_ACCOUNT SET AMOUNT=AMOUNT+:amount WHERE ACCOUNT_NO=:account_no";
	@Override
	public boolean depositeAmount(Account toAccount, double amount) {
		// TODO Auto-generated method stub
		MapSqlParameterSource m=new MapSqlParameterSource();
		m.addValue("amount",amount);
		m.addValue("account_no", toAccount.getAccountNo());
		return oracleJdbc.update(UPDATE_TO_ACCOUNT,m)!=0;
	}
	
}
