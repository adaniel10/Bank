package com.fdmgroup.bankaccounts;

import com.fdmgroup.bankcustomers.BankCustomer;

public class CheckingAccount extends BankAccount {

	private int checkNo = 0;
	
	public CheckingAccount(int balance, boolean isPersonal, BankCustomer bc) {
		super(balance, isPersonal, bc);
	}

	@Override
	public void withdraw(double withdraw) {
		balance -= withdraw;
        nextCheck();
        printsOutHowMuchTheUserDepositedOrWithdrawnFromTheirAccount(withdraw, "withdrawn");
	}

	@Override
	public void deposit(double deposit) {
		balance += deposit;
		nextCheck();
        printsOutHowMuchTheUserDepositedOrWithdrawnFromTheirAccount(deposit, "deposited");
	}

	private void printsOutHowMuchTheUserDepositedOrWithdrawnFromTheirAccount(double amount, String action) {
		System.out.println(String.format("CheckNum[%d] - %s has %s £%.2f from Account[%d]", 
        		checkNo, super.getBankCustomer().getName(), action, amount, super.getAccountID()));
	}
	
	public void nextCheck() { ++checkNo; }
	public int getCheckNo() { return checkNo; }
	
}
