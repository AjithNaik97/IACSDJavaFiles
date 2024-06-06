package com.app.tester;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tester {
	public static void main(String[] args) {
        String fileName = "Jan2023.txt";
        double sumOfDeposits = 0.0;
        double maxDepositAmount = 0.0;
        double shoppingExpenses = 0.0;
        double maxWithdrawalAmount = 0.0;
        String dateOfMaxWithdrawal = "";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // Read the header line

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String date = fields[0];
                String narration = fields[1];
                double withdrawalAmount = Double.parseDouble(fields[2]);
                double depositAmount = Double.parseDouble(fields[3]);

                // Calculate sum of all deposits
                sumOfDeposits += depositAmount;

                // Find max deposit amount
                if (depositAmount > maxDepositAmount) {
                    maxDepositAmount = depositAmount;
                }

                // Calculate shopping expenses
                if (narration.toLowerCase().contains("shopping")) {
                    shoppingExpenses += withdrawalAmount;
                }

                // Find the date on which maximum amount was withdrawn
                if (withdrawalAmount > maxWithdrawalAmount) {
                    maxWithdrawalAmount = withdrawalAmount;
                    dateOfMaxWithdrawal = date;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sum of all deposits = " + sumOfDeposits);
        System.out.println("Max deposit amount = " + maxDepositAmount);
        System.out.println("Shopping expenses = " + shoppingExpenses);
        System.out.println("Date on which max amount withdrawn = " + dateOfMaxWithdrawal);
    }
}
