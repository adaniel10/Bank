package com.fdmgroup.bankcustomers;

import java.util.ArrayList;
import java.util.List;
import com.fdmgroup.bankDEMO.*;

import com.fdmgroup.bankaccounts.BankAccount;

public abstract class BankCustomer {
	
	private static long ID = 2000000;
	private long customerID;
	private String name;
	private String address;
	private int taxID;
	protected List<BankAccount> accounts;
	
	public BankCustomer(String name, String address, int taxID) {
		this.customerID = ID;
		this.name = name;
		this.address = address;
		this.taxID = taxID;
		accounts = new ArrayList<BankAccount>();
		ID += 7;
	}
	
	public static long getID() { return ID; }
	public long getCustomerID() { return customerID; }
	public String getName() { return name; }
	public String getAddress() { return address; }
	public int getTaxID() { return taxID; }
	public List<BankAccount> getBankAccount() { return this.accounts; }
	public void addAccount(BankAccount ba){ accounts.add(ba); }
	public BankAccount getAccount(int index) { return accounts.get(index); }
	public int getNumOfAccounts() { return accounts.size(); }
	public void removeAllAccounts() { accounts.clear(); }
	
}
