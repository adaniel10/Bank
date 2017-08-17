package com.fdmgroup.bankaccounts;

import com.fdmgroup.bankcustomers.BankCustomer;

public abstract class BankAccount {
	
	private static int ID = 1000;
	private final int accountID;
	protected double balance;
	private boolean isPersonal;
	private BankCustomer bankCustomer;
	
	public BankAccount(int balance, boolean isPersonal, BankCustomer bc) {
		this.accountID = ID;
		this.balance = balance;
		this.isPersonal = isPersonal;
		this.bankCustomer = bc;
		ID += 5;
		bc.addAccount(this);
	}
	
	public void deposit(double deposit) {
		balance += deposit;
        System.out.println(String.format("%s has deposited £%.2f from Account[%d]", 
        		getBankCustomer().getName(), deposit, getAccountID()));
	}
	
	public void correction(double amount) {
		this.balance = amount;
	}

	public void printBalanceWithCustomerName(int i) {
			System.out.println(String.format("%s's Account[%s] Balance: £%.2f",
				this.getBankCustomer().getName(), this.getBankCustomer().getAccount(i).getAccountID(), this.balance));
	}
	
	public void setBalance(double balance) { this.balance = balance; }
	public abstract void withdraw(double withdraw);
	public int getAccountID() { return this.accountID; }
	public double getBalance() { return this.balance; }
	public boolean isPersonal() { return this.isPersonal; }
	public BankCustomer getBankCustomer() { return bankCustomer; }
		
}
