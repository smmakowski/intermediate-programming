/*
 * Filename: InsufficientFunds.java
 * Author: Stephen Makowski
 * Date: April 8, 2018
 * Purpose: User defined checked exception be thrown when account balance (savings or checking) is not enough to process account request
 */
public class InsufficientFunds extends Exception {
	public InsufficientFunds(String s) {
		super(s);
	}
}
