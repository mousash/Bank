package com.mousa;

public class CheckingAccount extends Account {

	private double creditLimit = -1000;
	
	public CheckingAccount(Date creationDate, Person owner, double creditLimit) {
		super(creationDate, owner);
		this.creditLimit = creditLimit;
	}
	
	@Override
	public boolean checkWithdraw (double amount, Account toAccount) {
		boolean status = false;
		if (amount > 0) {

			if (this.getBalance() - amount > this.creditLimit) {
				status = true;
			}
		}else {
			System.out.println("ERROR: less than 0");
		}
		return status;
	}
}
