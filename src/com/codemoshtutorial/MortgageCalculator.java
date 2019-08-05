package com.codemoshtutorial;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public MortgageCalculator() {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        greeting();
        System.out.println("Please provide some information");
        System.out.print("Principal Amount: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        int periodInYears = scanner.nextInt();
        int numberOfPayments = periodInYears * MONTHS_IN_YEAR;

        String mortgagePayment = calculateMonthlyMortgagePayment(principal, monthlyInterestRate, numberOfPayments);
        System.out.println("Monthly Mortgage Payment will be: " + mortgagePayment);
    }

    public static String calculateMonthlyMortgagePayment(int principal, float monthlyInterestRate, int numberOfPayments) {
        double monthlyMortgageAmount = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String monthlyMortgagePayment = currency.format(monthlyMortgageAmount);
        return monthlyMortgagePayment;
    }

    public static void greeting() {
        System.out.println("MORTGAGES WITH MEGOWN");
    }
}
