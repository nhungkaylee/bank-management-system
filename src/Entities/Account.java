package Entities;
import java.util.Scanner;

import java.sql.*;
public class Account {
	private String accountId;
	private String customerId;
	private String branchId;
	private double balance = 0;
	private int previousTransaction = 0;
	
	public Account() {
		super();
	}

	public Account(String accountId, String customerId,String branchId, double balance, int previousTransaction) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.branchId = branchId;
		this.balance = balance;
		this.previousTransaction = previousTransaction;
	}

	public void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	public void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = - amount;
		}
	}

	public void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " + accountId);
		System.out.println("\n");
		System.out.println("A: Checking Balance");
		System.out.println("B: Deposit");
		System.out.println("C: Withdraw");
		System.out.println("D: Previous Transaction");
		System.out.println("E: Exit");
		
		do {
			System.out.println("Enter an option");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch (option) {
			case 'A':
				System.out.println("Your balance is: " + balance);
				System.out.println("\n");
				break;
			case 'B': 
				System.out.println("Enter an amount to deposit: ");
				int amount2 = scanner.nextInt();
				deposit(amount2);
				System.out.println("\n Successful.");
				break;
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount3 = scanner.nextInt();
				withdraw(amount3);
				System.out.println("\n Successful.");
				break;
			case 'D':
				getPreviousTransaction();
				System.out.println("\n");
				break;
			default:
				System.out.println("Thank you!");;
			}
		} while (option != 'E');
	}

	public void printBalance(){
   	 	System.out.println("Current balance: " + balance);    	 
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void getPreviousTransaction() {
		if(previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		}
		else if(previousTransaction > 0) {
			System.out.println("Deposit: " + Math.abs(previousTransaction));		
		}
		else {
			System.out.println("No transaction occured");
		}
	}

	public void setPreviousTransaction(int previousTransaction) {
		this.previousTransaction = previousTransaction;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account [accountID = " + accountId + ", customerId = " + customerId + ", branchId = " + branchId +", balance=" + balance + "]";
	}
}
