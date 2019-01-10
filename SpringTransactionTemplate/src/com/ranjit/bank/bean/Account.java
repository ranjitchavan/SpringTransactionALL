package com.ranjit.bank.bean;



import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(includeFieldNames=true)
@NoArgsConstructor
public class Account {
	private String accountNo;
	private String accountName;
	private com.ranjit.bank.account.AccountType accountType;
	private double amount;
	


	public Account(String accountNo, String accountName) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public com.ranjit.bank.account.AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(com.ranjit.bank.account.AccountType accountType) {
		this.accountType = accountType;
	}
	
}
