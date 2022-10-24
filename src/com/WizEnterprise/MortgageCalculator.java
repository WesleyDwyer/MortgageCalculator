package com.WizEnterprise;

public class MortgageCalculator {
    private int principal;
    private float annualInterest;
    private byte years;

    private final byte PERCENT = 100;
    private final byte MONTH_OF_YEAR = 12;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double balance = (double)principal
                        * (Math.pow((double)(1.0F + monthlyInterest), (double)numberOfPayments) - Math.pow((double)(1.0F + monthlyInterest), (double)numberOfPaymentsMade))
                        / (Math.pow((double)(1.0F + monthlyInterest), (double)numberOfPayments) - 1.0D);
        return balance;
    }

    public double calMortgage() {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                        * (monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        //double calNumerator = (double) annualInterest * Math.pow((double)(1.0F + annualInterest), (double) years);
        //double calDenominator = Math.pow((double)(1.0F + annualInterest), (double) years) - 1.0D;
        //eturn (double) principal * (calNumerator / calDenominator);
        return mortgage;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calBalance(month);

        return balances;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTH_OF_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTH_OF_YEAR;
    }
}
