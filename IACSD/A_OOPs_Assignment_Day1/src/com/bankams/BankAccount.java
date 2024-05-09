package com.bankams;

public class BankAccount {
	private String accountHolderName;
	private double balance;
	private int accountNumber;
	
	public BankAccount()
	{
		accountNumber=0;
		accountHolderName="NA";
		balance=0.0;
	}
	
	public BankAccount(int accountNumber,String accountHolderName)
	{
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
	}

	@Override
	public String toString() {
		return "Account Number="+accountNumber+", Account Holder Name=" + accountHolderName + ", Balance=" + balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void depositMoney(double amt)
	{
		this.balance+= amt;
		System.out.println("Amount "+amt+" has been successfully deposited.");
	}
	
	public void withdrawMoney(double amt)
	{
		if(balance-amt<0)
		{
			System.out.println("\nInsufficient balance!");
		}
		else 
		{
			balance-=amt;
			System.out.println("Amount "+amt+" has been withdrawn");
		}
	}
	
	
}
