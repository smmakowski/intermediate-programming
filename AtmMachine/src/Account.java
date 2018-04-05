/*
 * Filename: Account.java
 * Author: Stephen Makowski
 * Date: April 8, 2018
 * Purpose: Account Class to store model and controllers for Bank Account for use with ATM Machine GUI
 */

public class Account {
	private static int withdrawalCount = 0; // withdrawal counter for service charge conditional
	private String name;
	private double balance;
	
	public Account(String name) {
		this.name = name;
		this.balance = 0.0;
	}
	// deposit into account returns 
	public double[] deposit(double amount) {
		this.balance += amount;
		return new double[] {this.balance, amount};
	}
	
	public boolean withdrawl(double amount) throws InsufficientFunds, IllegalArgumentException {
		// if sufficient amount in balance attempt to withdraw
		if (hasSufficientBalance(amount)) {
			// if amount requested not in $20's throw 'IllegalArgumentException'
			if (amount % 20.0 != 0.0) {
				throw new IllegalArgumentException();
			} else { // remove amount from account balance and return amout
				// check if service charge necessary and if so, add charge and set true for notification
				boolean requiresServiceCharge = false;
				if (withdrawalCount >= 4) {
					requiresServiceCharge = true;
					this.balance -= amount + 1.50;
				} else { // withdraw normally without charge
					this.balance -= amount;
				}
				
				withdrawalCount += 1; // increase withdrawal count for success
				return requiresServiceCharge;
			}
		} else {
			throw new InsufficientFunds(this.name);
		}
	}
	
	public void transfer(double amount, Account destination) throws InsufficientFunds {
		// if sufficient amount remove amount from balance and deposit into destination
		if (hasSufficientBalance(amount)) {
			this.balance -= amount;
			destination.deposit(amount);
		} else { // else throw User Defined Exception
			throw new InsufficientFunds(this.name);
		}
	}
	// essentially a get method for instance balance
	public double balance() {
		return this.balance;
	}
	
	public String getName() {
		return this.name;
	}
	// helper function for determination of valid balance
	private boolean hasSufficientBalance(double amount) {
		return this.balance - amount >= 0;
	}
}
