package com.mousa;


public class SavingAccount extends Account{

	private com.mousa.Date fixedDate;
	
	public SavingAccount(com.mousa.Date creationDate, Person owner) {
		super(creationDate, owner);
		// TODO Auto-generated constructor stub
	}

	
	public void fixAccount(com.mousa.Date endDate) {
		this.fixedDate = endDate;
		
	}
	
	protected boolean isFixed() {
		
		boolean status = false;
		status = !(fixedDate == null);
		
		if(status == true) {
			System.out.println("ERROR: Account is fixed");
		}
		return status;
		
	}
	
	
	@Override
    protected boolean checkDeposit (double amount, Account fromAccount) {
		boolean status = false;
    	if (!this.getPerson().getName().equals(fromAccount.getPerson().getName())) {
    		return status;
    	}
    	

		if (amount > 0) {

	        if  (!isFixed() && !this.getDate().isBefore(new Date(1,1,2000))) {
	            status = true;
	        }
		}else {
			System.out.println("ERROR: less than 0");
		}
        return status;
    }
	
	@Override
	public boolean checkWithdraw (double amount, Account toAccount) {
		boolean status = false;
    	if (!this.getPerson().getName().equals(toAccount.getPerson().getName())) {
    		return status;
    	}
    	
 
		if (amount > 0) {

			if (this.getBalance() >= amount && !isFixed()) {
				status = true;
			}else {
				System.out.println("ERROR: less than 0");
			}
		}
		return status;
	}
}
