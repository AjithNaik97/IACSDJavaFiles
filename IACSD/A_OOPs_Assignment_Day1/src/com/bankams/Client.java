package com.bankams;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int c,actn;
		String name;
		double amt;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Account Number: ");
		actn=in.nextInt();
	
		System.out.print("Enter your name:");
		name=in.next();
		BankAccount b=new BankAccount(actn,"name");
		while(true)
		{
			System.out.println("\n1. Deposit, 2. Withdraw, 3.Check Balance, 4.Exit");
			System.out.println("Enter your choice:");
			c=in.nextInt();
			switch (c)
			{
			case 1:
				System.out.print("Enter the amount to be deposited: ");
				amt=in.nextInt();
				b.depositMoney(amt);
				break;
			
			case 2:
				System.out.print("Enter the amount to be withdrawn: ");
				amt=in.nextInt();
				b.withdrawMoney(amt);
				break;
				
			case 3:
				System.out.println("Balance= "+b.getBalance());
				break;
				
			case 4:
				System.out.println("Exiting...");
				return;
				
			default:
				System.out.println("Invalid Input!");
			}
		}
	}

}
