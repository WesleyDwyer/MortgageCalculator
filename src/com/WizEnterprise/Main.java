package com.WizEnterprise;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    static final byte PERCENT = 100;
    static final byte MONTH_OF_YEAR = 12;

    public static void main(String[] args) {
        // write your code here

        int principal;
        float annualInterestRate;
        float interestRate;//annualInterestRate / 100
        float monthlyInterestRate; // interestRate / 12
        byte period;//in period
        double mortgage = 0;

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Principal: ");
            principal = Integer.parseInt(scanner.nextLine());
            if(principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Enter a value between 1000 and 1000000.");
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = Float.parseFloat(scanner.nextLine());
            if(annualInterestRate >= 1 && annualInterestRate <= 30)
                break;

            System.out.println("Enter a value between 1 and 30.");
        }


        interestRate = calculateInterest(annualInterestRate);
        monthlyInterestRate = interestRate / MONTH_OF_YEAR; //r

        while(true){
            System.out.print("Period (Years): ");
            period = Byte.parseByte(scanner.nextLine());
            if(period >= 1 && period <= 30)
                break;
            System.out.println("Enter year between 1 and 30.");
        }


        int n = period * MONTH_OF_YEAR; //number of payment
        mortgage = calMortgage(principal,monthlyInterestRate,n);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public static float calculateInterest(float annualInterestRate){
        return annualInterestRate / PERCENT;
    }

    public static float calMonthlyInterestRate(float interestRate){
        return interestRate / MONTH_OF_YEAR;
    }

    public static double calMortgage(int P, float r, int n)
    {
        double calNumerator = r * (Math.pow((1+ r),n));
        double calDenominator = (Math.pow((1 + r),n)) - 1;
        return P * (calNumerator / calDenominator);
    }
}
