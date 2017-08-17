package com.fdmgroup.bankDEMO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fdmgroup.bankaccounts.*;
import com.fdmgroup.bankcustomers.*;

public class Menu {
	
	private Scanner in = new Scanner(System.in);
	private List<BankCustomer> bc;
	private List<BankAccount> ba;
	
	public Menu () {
		bc = new ArrayList<>();
		ba = new ArrayList<>();
	}
	
	public void displayWelcome() {
		System.out.println("***Welcome to the Java Bank***");
		chooseCustomerType();
	}
	
	public void chooseCustomerType() {
		System.out.println("\nPlease select your bank type:");
		System.out.println("1 - Person");
		System.out.println("2 - Company");
		
		int reply = in.nextInt();
		enterCustomerDetails(reply);
	}
	
	public void enterCustomerDetails(int reply) {
		
		System.out.print("\nPlease enter your name: ");
		String name = in.next();
		System.out.print("Please enter your address: ");
		String address = in.next();
		System.out.print("Please enter your tax ID: ");
		int taxID = in.nextInt();
		
		if(reply == 1) {
			bc.add(new Person(name,address,taxID));
			displayOptions("Personal");
		}
		else {
			bc.add(new Company(name,address,taxID));
			displayOptions("Buisness");
		}
	}
	
	private void displayOptions(String r) {
		System.out.println("\nPlease select an account you would like to create:");
		
		System.out.println("1 - "+r+" Savings");
		System.out.println("2 - "+r+" Checking");
		
		int reply = in.nextInt();
		
		if(reply == 1) {
			String accountType = r + " Savings";
			System.out.println("You have selected "+accountType+" Account.");
			enterAccountDetails(accountType);
		}
		else if(reply == 2) {
			String accountType = r + " Checking";
			System.out.println("You have selected "+accountType+" Account.");
			enterAccountDetails(accountType);
		}
		else
			System.out.println("You have selected an invalid option.");
			
	}
	
	private void enterAccountDetails(String accountType) {

		System.out.print("Please enter an initial amount for your account: ");
		int amount = in.nextInt();
		
		String[] tokens = accountType.split("\\s+");
		
		boolean isPersonal = false;
				
		if(tokens[1].equals("Savings"))
			ba.add(new SavingsAccount(amount, isPersonal, bc.get(0)));
		else
			ba.add(new CheckingAccount(amount, isPersonal, bc.get(0)));
		
		System.out.println("Processing....Your account has been successfully created.\n");
		displayMoreOptions();
	}
	
	private void displayMoreOptions() {
		
		System.out.println("Choose any one of the options indicated below:");
		System.out.println("1 - Check Balance");
		System.out.println("2 - Deposit");
		System.out.println("3 - Withdraw");
		System.out.println("4 - Create a New Account");
		System.out.println("5 - View My Accounts");
		System.out.println("6 - Remove an Account");
		System.out.println("7 - Back to Main Menu");
		
		int reply = in.nextInt();
		loopMenu(reply);
	}
	
	private void loopMenu(int reply) {
		
		switch(reply) {
		case 1:
			System.out.println("---Balance---");
			print(bc.get(0));
			break;
		case 7:
			displayWelcome();
			break;
		}
	}
	
	public void print(BankCustomer bc)
	{
		for(int i=0; i<bc.getNumOfAccounts(); i++) {
			bc.getAccount(i).printBalanceWithCustomerName(i);
		}
		System.out.println();
	}

}
