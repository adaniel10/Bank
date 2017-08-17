package com.fdmgroup.bankcustomers;

import java.util.ArrayList;
import java.util.List;
import com.fdmgroup.bankaccounts.*;

public class Person extends BankCustomer implements PersonalAccount{
	
	private List<PersonalAccount> personalAccount;
	
	public Person(String name, String address, int taxID) {
		super(name, address, taxID);
		personalAccount = new ArrayList<PersonalAccount>();
	}
	
	public void resetBalance() {
		for(BankAccount account : accounts) {
			account.correction(0.0);
		}
	}

	public List<PersonalAccount> getPersonalAccount() {
		return personalAccount;
	}

	public void addAccount(PersonalAccount bankAccount) {
		personalAccount.add(bankAccount);
	}
	
	
	
	
	
}
