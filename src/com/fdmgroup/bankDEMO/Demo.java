package com.fdmgroup.bankDEMO;

import com.fdmgroup.bankaccounts.*;
import com.fdmgroup.bankcustomers.*;

public class Demo {

	public static void main(String[] args) {
		
		Person bob = new Person("Bob", "9 Lomond Drive", 6501);
		Person fred = new Person("Fred", "8 Summerville Avenue", 6541);
		Company fdm = new Company("FDM", "1 West Regent", 6575);
		Company sky = new Company("Sky", "14 Argyle Street", 6521);
		
		CheckingAccount capBob = new CheckingAccount(1000,true,bob);
		SavingsAccount savBob = new SavingsAccount(50,true,bob);
		
		CheckingAccount capFDM = new CheckingAccount(2000,false,fdm);
		CheckingAccount capFDM2 = new CheckingAccount(3000,false,fdm);
		SavingsAccount savFDM = new SavingsAccount(10,false, fdm);
		SavingsAccount savFDM2 = new SavingsAccount(10,false, fdm);

		//bob
		print(bob);
		bob.getAccount(0).withdraw(1800);	//checking account - capBob
		print(bob);
		bob.getAccount(1).withdraw(60);		//savings account - savBob
		print(bob);
		bob.getAccount(1).deposit(10);
		print(bob);
		bob.resetBalance();
		print(bob);
		capBob.correction(55.01);		//adding money to account 1005
		print(bob);
		
		System.out.println("-----------------------------------------");
		
		//fdm
		print(fdm);
		System.out.println("Num Of Accounts: "+fdm.getNumOfAccounts());
		fdm.addMoneyToAllAccounts(10);
		print(fdm);
		fdm.removeAllAccounts();
		System.out.println("Num Of Accounts: "+fdm.getNumOfAccounts());
		print(fdm);
		
//		Menu m = new Menu();
//		m.displayWelcome();
		
	}
	
	//Prints out all the accounts owned by the user
	public static void print(BankCustomer bc)
	{
		for(int i=0; i<bc.getNumOfAccounts(); i++) {
			bc.getAccount(i).printBalanceWithCustomerName(i);
		}
		System.out.println();
	}

}
