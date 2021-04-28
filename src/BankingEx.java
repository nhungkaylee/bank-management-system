import java.awt.*;
import java.awt.event.*;
import java.net.SecureCacheResponse;

import javax.swing.*;

import Entities.Account;
import Entities.Branch;
import Entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class BankingEx {
	Account account;
	Customer customer;
	Branch branch;
	
	public BankingEx() {};
	public static void Menu(){
		System.out.println("\n 1.	Add the brach");
		System.out.println(" 2.	Edit the brach ");
		System.out.println(" 3.	Remove the brach");
		System.out.println(" 4.	Add the customer");
		System.out.println(" 5.	Edit the customer");
		System.out.println(" 6.	Remove the customer");
		System.out.println(" 7.	Open an account for a customer");
		System.out.println(" 8.	Display balance, Deposit/withdraw money for a customer account");
		System.out.println(" 9.	Exit ");
	}
	
	// create new customer
	public static void createCustomer() throws ClassNotFoundException, SQLException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			String id = scanner.next();
			System.out.print("Enter name: ");
			String name = scanner.next();
			
			//Create connect db to validation
			try {
				Connect con = new Connect();
				String query = "insert into dbo.customer values ('"+id+"','"+name+"')";
	        	con.statement.executeUpdate(query);
	        	System.out.println("Add customer success.");
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Id or name customers existed. Please re-input.");
	        	continue;
			}
			break;
		}	
	}
	
	// edit customer
	public static void updateCustomer() throws ClassNotFoundException, SQLException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			String id = scanner.next();
			System.out.print("Enter new name: ");
			String name = scanner.next();
			
			//Create connect db to validation
			try {
				Connect con = new Connect();
				String query  = "update dbo.customer set customerName = '"+name+"' where customerId = '"+id+"'";
	        	con.statement.executeUpdate(query);
	        	System.out.println("Update customer success.");
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Customer Id not exist!");
	        	continue;
			}
			break;

		}
	}
	
	//remove customer
	public static void removeCustomer() throws ClassNotFoundException, SQLException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			String id = scanner.next();
			
			//Create connect db to validation
			try {
				Connect con = new Connect();
				String query  = "delete from dbo.customer where customerId = '"+id+"'";
	        	con.statement.executeUpdate(query);
	        	
	        	System.out.println("Remove customer success.");
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Customer Id not exist!");
	        	continue;
			}
		break;

		}
	}
	
	// create new branch
	public static void createBranch() throws ClassNotFoundException, SQLException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			String id = scanner.next();
			System.out.print("Enter name: ");
			String name = scanner.next();
			
			//Create connect db to validation
			try {
				Connect con = new Connect();
	        	String query = "insert into dbo.branch values ('"+id+"','"+name+"')";
	        	con.statement.executeUpdate(query);
				System.out.println("Add branch success.");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Id or name has exist branch. Please re-input.");
				continue;
			}
			
			break;

		}
	}

	// edit branch 
	public static void updateBranch() throws ClassNotFoundException, SQLException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			String id = scanner.next();
			System.out.print("Enter new name: ");
			String name = scanner.next();
			
			//Create connect db to validation
			try {
				Connect con = new Connect();
	        	String query  = "update dbo.branch set branchName = '"+name+"' where branchId = '"+id+"'";
	        	con.statement.executeUpdate(query);

				System.out.println("Update branch success.");
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Branch Id not exist!");
				continue;
				
			}
			
			break;

		}
	}

	//remove branch 
	public static void removeBranch() throws ClassNotFoundException, SQLException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			String id = scanner.next();
			
			//Create connect db to validation
			try {
				Connect con = new Connect();
				String query  = "delete from dbo.branch where branchId = '"+id+"'";
	        	con.statement.executeUpdate(query);
	        	System.out.println("Remove branch success.");
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Branch Id not exist!");
				continue;
			}
			break;

		}
	}
	
	// create new account
	public static void createAccount() throws SQLException, ClassNotFoundException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter accountId: ");
			String accountId = scanner.next();
			System.out.print("Enter customerId: ");
			String customerId = scanner.next();
			System.out.print("Enter branchId: ");
			String branchId = scanner.next();
			
			//Create connect db to validation
			try {
				Connect con = new Connect();
				String query = "insert into dbo.account values ('"+customerId+"','"+accountId+"','"+branchId+"', 0, 0)";
	        	con.statement.executeUpdate(query);
	        	
	        	System.out.println("Add account success.");
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Id account existed. Please re-input.");
	        	continue;
			}
			
			break;
		}	
	}
	
	//edit account
	public static void updateAccount() throws ClassNotFoundException, SQLException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter accountId: ");
			String accountId = scanner.next();
			System.out.print("Enter new customerId: ");
			String customerId = scanner.next();
			System.out.print("Enter new branchId: ");
			String branchId = scanner.next();
			System.out.print("Enter balance: ");
			String balance = scanner.next();
			
			//Create connect db to validation
			Connect con = new Connect();
			String query  = "select * from dbo.account";
			ResultSet pmt = con.statement.executeQuery(query);
			while (pmt.next()) {
	           if(pmt.getString("accountId").equals(accountId)) {
	        	   query  = "update dbo.Account set customerId = '"+customerId+"', branchId = '"+branchId+"', balance = '"+balance+"' where accountId = '"+accountId+"' ";
	        	   con.statement.executeUpdate(query);
	        	   continue;
	           }
	           else {
	        	   System.err.println("Account Id not exist!");
	        	   break;
	           }
			}

			System.out.println("Update account success.");
			break;

		}
	}
	
	//remove account
	public static void removeAccount() throws ClassNotFoundException, SQLException {
		while (true) {
			// input id and name
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			String id = scanner.next();
			
			//Create connect db to validation
			Connect con = new Connect();
			String query  = "select * from dbo.account";
			ResultSet pmt = con.statement.executeQuery(query);
			while (pmt.next()) {
	           if(pmt.getString("accountId").equals(id)) {
	        	   query  = "delete from dbo.account where accountId = '"+id+"'";
	        	   con.statement.executeUpdate(query);
	        	   continue;
	           }
	           else {
	        	   System.err.println("Account Id not exist!");
	        	   break;
	           }
			}

			System.out.println("Remove account success.");
			break;

		}
	}
	
	//transaction customer account: display balance, deposit, withdraw money
	public static void transactionAccount() throws ClassNotFoundException, SQLException {
		
		while(true) {
			//input accountID
			System.out.println("Enter accountId: ");
			Scanner scanner = new Scanner(System.in);
			String accountId = scanner.next();
			String customerId ="";
			String branchId ="";
			double balance = 0;
			int previousTransaction = 0;
			//connect db to find accountId
			try {
				Connect con = new Connect();
				String query  = "select * from dbo.account where accountId = '"+accountId+"' ";
				ResultSet pmt = con.statement.executeQuery(query);
				
//				if(pmt.next() == false) {
//					System.err.println("Account ID not exist");
//					continue;
//				}
//				
				while(pmt.next()) {
					customerId = pmt.getString("customerId");
					branchId = pmt.getString("branchId");
					balance = pmt.getDouble("balance");
					previousTransaction = pmt.getInt("previousTransaction");
				}
				
				//show menu transaction
				Account currentAccount = new Account(accountId, customerId, branchId, balance, previousTransaction);
				currentAccount.showMenu();
				
				//Save to db
				System.out.println(currentAccount.getBalance());
				query = "update dbo.Account set balance = '"+currentAccount.getBalance()+"' where accountId = '"+accountId+"'";
		 	   	con.statement.executeUpdate(query);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Account id not exist");
				continue;
			}			
		}
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BankingEx be = new BankingEx();
		char option;
		Scanner scanner = new Scanner(System.in);
		do {
			be.Menu();
			System.out.println("Enter an option");
			option = scanner.next().charAt(0);
			System.out.println("\n");
		
			switch (option) {
			case '1': {
				createBranch();
				break;
			}
			
			case '2':{
				updateBranch();
				break;
			}
			
			case '3': {
				removeBranch();
				break;
			}
			
			case '4': {
				createCustomer();
				break;
			}
		
			case '5': {
				updateCustomer();
				break;
			}
			
			case '6': {
				removeCustomer();
				break;
			}
			
			case '7': {
				createAccount();
				break;
			}
			
			case '8': {
				transactionAccount();
				break;
			}
			
			default:
				System.out.println("Thank you!");
			}
		}while (option != '9');
		
	}
	
}
