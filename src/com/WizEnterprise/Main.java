package com.WizEnterprise;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1000.0D, 1_000_000.0D);
        float annualInterestRate = (int) Console.readNumber("Annual Interest Rate: ", 1.0D, 30.0D);
        byte years = (byte) Console.readNumber("Period (Years): ", 1.0D, 30.0D);

        var calculator = new MortgageCalculator(principal,annualInterestRate,years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }
}