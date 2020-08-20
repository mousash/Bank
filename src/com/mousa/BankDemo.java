package com.mousa;

public class BankDemo {

	public static void main(String[] args) {

		Person person1 = new Person("mousa", 26);
		Person person2 = new Person("goli", 24);
		Person person3 = new Person("alex", 30);
		Person person4 = new Person("ali", 22);
		Date date = new Date();

		CheckingAccount acc1 = new CheckingAccount(date, person1, -1000);
		CheckingAccount acc2 = new CheckingAccount(date, person2, -1000);
		CheckingAccount acc3 = new CheckingAccount(date, person3, -1000);
		CheckingAccount acc4 = new CheckingAccount(date, person4, -1000);
		
		acc1.deposit(1000);
		acc2.deposit(1100);
		acc3.deposit(1200);
		acc4.deposit(1300);
		
		Bank bank = new Bank();
		
		bank.addAccount(acc1);
		bank.addAccount(acc2);
		bank.addAccount(acc3);
		bank.addAccount(acc4);
		

		// balance
		bank.printAccountsSorted(1);
		// owner name
		bank.printAccountsSorted(2);
		// account id
		bank.printAccountsSorted(3);	
		
		
	}
	
}
