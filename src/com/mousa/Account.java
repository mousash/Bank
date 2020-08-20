package com.mousa;

import java.util.Random;
import java.util.Comparator;

public class Account {

	private long accountId;
	private double balance;
	private Person owner;
	private Date creationDate;
	
//	public Account() {
//		
//	}
	
	public Account(Date creationDate, Person owner) {
		this.creationDate = creationDate;
		this.owner = owner;
		this.balance = 0;
		this.accountId = (new Random()).nextInt(90000000) + 1000000000;
	}

	public long getAccountID() {
		
		return accountId;
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	protected Person getPerson() {
		return owner;
	}
	
	protected Date getDate() {
		return creationDate;
	}
	
  protected boolean checkWithdraw(double amount, Account targetAccount) {
	  boolean status = false;
	if (amount > 0) {
		status = true;
	}
	return status;
	 }
	   

	 protected boolean checkDeposit(double amount, Account sourceAccount) {
	  if (amount > 0) {
	   return true;
	  }
	  return false;
	 }
	
	protected boolean deposit(double amount) {
		this.balance += amount;
		return true;
	}
	
	protected boolean withdraw(double amount) {
		this.balance -= amount;
		return true;
	}
	
	@Override
    public String toString() {
        return "Account [AccountID: " + accountId + ", CreationDate: " + creationDate + ", Owner: " + owner + ", Balance: " + balance + "]";
    }
	
	
    public static class OwnerNameComparator implements Comparator < Account > {
        @Override
        public int compare(Account account1, Account account2) {
            String name1 = account1.owner.getName();
            String name2 = account2.owner.getName();
            int result = name1.compareToIgnoreCase(name2);
            return result;
        }
    }
    
    
    public static class BalanceComparator implements Comparator < Account > {
        @Override
        public int compare(Account account1, Account account2) {
            double balance1 = account1.getBalance();
            double balance2 = account2.getBalance();
            if (balance1 < balance2) {
                return -1;
            }
            else if (balance1 > balance2) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    
    
    public static class AccountIdComparator implements Comparator < Account > {
        @Override
        public int compare(Account account1, Account account2) {
            long id1 = account1.getAccountID();
            long id2 = account2.getAccountID();
            if (id1 < id2) {
                return -1;
            }
            else if (id1 > id2) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

}
