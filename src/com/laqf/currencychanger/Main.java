package com.laqf.currencychanger;

import com.laqf.currencychanger.utils.ChooseCurrency;
import com.laqf.currencychanger.utils.ExchangeCurrency;
import com.laqf.currencychanger.utils.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************************************************");
        System.out.println("Welcome to Currency Changer :]");
        System.out.println("*****************************************************");

        try {
            while (true) {
                System.out.println("Choose a currency: ");
                Menu.showMenu();

                int option = -1;
                while (option == -1) {
                    try {
                        option = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid numeric option.");
                        scanner.nextLine(); // limpiar el buffer del scanner
                    }
                }
                if (option < 1 || option > 5) {
                    System.out.println("Invalid option. Please choose a valid option.");
                    continue;
                }
                if (option == 5) {
                    break;
                }

                String from = ChooseCurrency.chooseCurrency(option);

                System.out.println("Choose a currency for conversion: ");

                int optionTwo = 0;
                while (optionTwo == 0) {
                    try {
                        optionTwo = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid numeric option.");
                        scanner.nextLine(); // limpiar el buffer del scanner
                    }
                }

                if (optionTwo < 1 || optionTwo > 5) {
                    System.out.println("Invalid option. Please choose a valid option.");
                    continue;
                }
                String to = ChooseCurrency.chooseCurrency(optionTwo);

                System.out.println("Enter the amount: ");

                double amount = -1;
                while (amount == -1) {
                    try {
                        amount = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid numeric amount.");
                        scanner.nextLine();
                    }
                }

                ExchangeCurrency.exchangeCurrency(amount, from, to);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid numeric option or amount.");
        } finally {
            scanner.close(); // cerrar el scanner al salir del bucle
        }
    }
}
