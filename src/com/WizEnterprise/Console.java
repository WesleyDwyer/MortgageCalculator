package com.WizEnterprise;

import java.util.Scanner;

public class Console {
    final private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            //scanner.close();
            System.out.println("Enter year between " + min + " and " + max);
        }
        return value;
    }

    //overload Method
    public static double readNumber(String prompt){
        return scanner.nextDouble();
    }

}
