package com.fdmgroup.bankaccounts;

import com.fdmgroup.bankcustomers.BankCustomer;

public class SavingsAccount extends BankAccount {
	
	private double interestRate;

	public SavingsAccount(int balance, boolean isPersonal, BankCustomer bc) {
		super(balance, isPersonal, bc);
		interestRate = 0.0;
	}

	@Override
	public void withdraw(double withdraw) {
			            
	     if(super.getBalance() >= withdraw)
	     {
	    	 balance -= withdraw;
	    	 printsOutHowMuchTheUserDepositedOrWithdrawnFromTheirAccount(withdraw, "withdrawn");
	     }
	     else
	    	 System.out.println("Unable to withdraw due to insufficient funds.");
	}
	
	@Override
	public void deposit(double deposit) {
		balance += deposit;
		printsOutHowMuchTheUserDepositedOrWithdrawnFromTheirAccount(deposit, "deposited");
	}
	
	private void printsOutHowMuchTheUserDepositedOrWithdrawnFromTheirAccount(double amount, String action) {
		System.out.println(String.format("%s has %s £%.2f from Account[%d]", 
		 		super.getBankCustomer().getName(), action, amount, super.getAccountID()));
	}

	public double getInterestRate() { return interestRate; }
	public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

}
