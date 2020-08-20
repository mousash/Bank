package com.mousa;

import java.util.ArrayList;
import java.util.Collections;

public class Bank {

	
	private ArrayList<Account> accountList;
	
	public Bank() {
		this.accountList = new ArrayList<Account>();
	}
	
	public void addAccount(Account newAccount) {
		System.out.println(newAccount.getAccountID());
		accountList.add(newAccount);
	}
	
	public int getNumberOfAccounts() {
		return accountList.size();
	}
	
	public boolean transfer(long accountFromID, long accountToId, double amount) {
		
		boolean status = false;
		
		if (accountFromID == accountToId) {
	            return status;
		}
		 
		Account accountTo = null;//new Account(null, null);
		Account accountFrom = null;//new Account(null, null);
		
		for(Account account: accountList) {
			if (account.getAccountID() == accountToId) {
				accountTo = account;
			}
			
			if (account.getAccountID() == accountFromID) {
				accountFrom = account;
			}
		}
		
//		if(accountTo == null || accountFrom == null) {
//			System.out.println("ERROR");
//		}
		
		if (checkTransfer(accountFrom, accountTo, amount)) {
			//Transfer
			accountTo.deposit(amount);
			accountFrom.withdraw(amount);
			status = true;
			System.out.println("Transfered");
		}else {
			status = false;
		}
		
		return status;
	}
	
	
	
	protected boolean checkTransfer(Account accountFrom, Account accountTo, double amount) {
		
		 if (accountFrom == null || accountTo == null || accountFrom == accountTo) {
	            return false;
	        }
	        
	        if(accountFrom.checkWithdraw(amount, accountTo) && accountTo.checkDeposit(amount, accountFrom)) {
	        	return true;
	        }else {
	        	return false;
	        }
	}

	
	@Override
	public String toString() {
		return accountList + "";
	}
	
	
//	@Override
//	public String toString() {
//		String allDatas = "";
//		for(Account account: accountList) {
//			String ownerName = account.getPerson().getName();
//			int ownerAge = account.getPerson().getAge();
//			String date = account.getDate().toString();
//			
//			allDatas += "[ Name:" + ownerName + ", Age:" + ownerAge +", CreationDate:" + date + "]\n";
//		}
//		return allDatas;
//	}
	
	
	public void printAccountsSorted(int sortingCriteria) {
		ArrayList < Account > accountsCopy = new ArrayList < > ();
		accountsCopy.addAll(accountList);
		
		switch (sortingCriteria) {
			case 1:
				// balance
				System.out.println("Sorting accounts by balance:");
				Collections.sort(accountsCopy, new Account.BalanceComparator());
				break;
			case 2:
				// owner name
				System.out.println("Sorting accounts by owner name:");
				Collections.sort(accountsCopy, new Account.OwnerNameComparator());
				break;
			case 3:
				// account ID
				System.out.println("Sorting accounts by account ID:");
				Collections.sort(accountsCopy, new Account.AccountIdComparator());
				break;
				
			default:
				System.out.println("Wrong Input!");
				break;
		}
		
		for (Account currentAccount: accountsCopy) {
			System.out.println(currentAccount.toString());
		}
		
	}
}