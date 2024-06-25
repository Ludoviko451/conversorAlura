package com.laqf.currencychanger.utils;

public class ChooseCurrency {

    public static String chooseCurrency(int option){
        String currency = "";
        switch (option) {
            case 1:
                currency = "COP";
                break;
            case 2:
                currency = "USD";
                break;
            case 3:
                currency = "EUR";
                break;
            case 4:
                currency = "BRL";
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        return currency;
    }
}
