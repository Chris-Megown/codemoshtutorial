package com.codemoshtutorial;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public MortgageCalculator() {
        Scanner scanner = new Scanner(System.in);
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal;
        float annualInterestRate;
        int periodInYears;

        greeting();
        System.out.println("Please provide some information");

        while(true){
            System.out.print("Principal Amount ($1,000 - $1,000,000): ");
            principal = scanner.nextInt();
            if (principal>=1000&&principal<=1_000_000)
                break;
            System.out.println("Please enter a value between $1,000 - $1,000,000");
        }
        while(true){
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate<=12&&annualInterestRate>0)
                break;
            System.out.println("Please enter a value greater than 0 and less than 12");
        }
        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;

        while(true){
            System.out.print("Period (Years): ");
            periodInYears = scanner.nextInt();
            if (periodInYears<=30&&periodInYears>=1) {
                break;
            }
            System.out.println("Please enter a value between 1 - 30");
        }
        int numberOfPayments = periodInYears * MONTHS_IN_YEAR;

//        do {
//            System.out.print("Principal Amount ($1,000 - $1,000,000: ");
//            principal = scanner.nextInt();
//            if (principal>1000000||principal<1000)
//                System.out.println("Please enter a value between $1,000 - $1,000,000");
//        } while (principal>1000000||principal<1000);
//
//        do {
//            System.out.print("Annual Interest Rate: ");
//            annualInterestRate = scanner.nextFloat();
//            if (annualInterestRate>12||annualInterestRate<=0)
//                System.out.println("Please enter a value greater than 0 and less than 12");
//        } while (annualInterestRate>12||annualInterestRate<=0);
//
//
//
//        do {
//            System.out.print("Period (Years): ");
//            periodInYears = scanner.nextInt();
//            if (periodInYears>30||periodInYears<1)
//                System.out.println("Please enter a value between 1 - 30");
//        } while (periodInYears>30||periodInYears<1);


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
