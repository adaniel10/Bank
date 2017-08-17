package com.fdmgroup.bankcustomers;

import com.fdmgroup.bankaccounts.*;

public class Company extends BankCustomer implements BusinessAccount{

	public Company(String name, String address, int taxID) {
		super(name, address, taxID);
	}
	
	public void addMoneyToAllAccounts(double amount) {
		
		System.out.println(String.format("Adding £%.2f to all of your accounts.",amount));

		for(BankAccount account : accounts) {
			account.deposit(amount);
		}
	}

}
