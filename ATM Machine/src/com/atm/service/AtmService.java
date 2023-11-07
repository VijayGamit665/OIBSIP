package com.atm.service;

import java.util.ArrayList;
import java.util.Scanner;

public class AtmService {

    ArrayList<String> transactionsList = new ArrayList<>();
    double balance;
    int pin = 8866;

    //for pin validation
    public void checkPin() {
        System.out.println("<-------" + "Enter Your Pin" + "------->");
        Scanner sc = new Scanner(System.in);
        int typeYourPin = sc.nextInt();
        if (pin == typeYourPin) {
            menu();//select option from menu
        } else {
            System.out.println("Enter Valid Pin");
        }
    }

    //for main menu ,select option for transactions
    public void menu() {

        System.out.println();
        System.out.println("-------------" + "Well Come To ATM Machine" + "------------");
        System.out.println();
        System.out.println("Enter Your Choice");
        System.out.println("1.Transaction History");
        System.out.println("2.Withdraw Money");
        System.out.println("3.Deposit Money");
        System.out.println("4.Transfer Money");
        System.out.println("5.Quit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if (opt == 1) {
            transactionHistory();
        } else if (opt == 2) {
            withdrawMoney();
        } else if (opt == 3) {
            depositMoney();
        } else if (opt == 4) {
            moneyTransfer();
        } else if (opt == 5) {
            quit();
        } else {
            System.out.println("Enter Valid Choice");
        }
    }

    //it will display transaction history
    public void transactionHistory() {

        System.out.println("------Transaction History--------");
        System.out.println();
        System.out.println((transactionsList + "\n"));
        System.out.println();
        System.out.println("Your Current Balance is = " + balance);
        menu();
    }

    //for withdraw money
    public void withdrawMoney() {
        System.out.println("Enter Amount Withdraw:");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextInt();

        System.out.println("Please Confirm Amount " + (amount));
        System.out.println("1. Yes");
        System.out.println("2. NO");
        Scanner sr = new Scanner(System.in);
        int opt = sc.nextInt();
        if (opt == 1) {
            balance = balance + amount; //balance+=amount;
            System.out.println("Money Withdraw is Successful");
        } else if (opt == 2) {
            depositMoney();
        }
        transactionsList.add((" -- " + amount + " -- " + "Withdraw Money") + "\n");
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amount;
            System.out.println("Money Withdraw Successful");
        }
        System.out.println();
        menu();
    }

    //for deposit money
    public void depositMoney() {
        System.out.println("Enter Amount for Deposit");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextInt();
        System.out.println("Please Confirm Amount " + (amount));
        System.out.println("1. Yes");
        System.out.println("2. NO");
        Scanner sr = new Scanner(System.in);
        int opt = sc.nextInt();
        if (opt == 1) {
            balance = balance + amount;
            System.out.println("Money Deposit is Successful");
        } else if (opt == 2) {
            depositMoney();
        }
        transactionsList.add(" -- " + amount + " -- " + "Deposit Money" + "\n");
        System.out.println();
        menu();
    }

    //for balance check
    public void checkBalance() {
        System.out.println("Your Balance " + balance);
    }

    //for money transfer
    public void moneyTransfer() {
        mobileNumberValidation();
        accountNumberValidation();
        processToMoney();
    }

    //validate mobileNumber and acc No
    public void mobileNumberValidation() {
        Scanner sc = new Scanner(System.in);
        String mobileNumber = null;
        int x;
        for (x = 0; x <= 3; x++) {
            System.out.println("Enter your Mobile number");
            mobileNumber = sc.next();
            String regex = "\\d{10}";
            System.out.println("\n The Mobile Number is:" + mobileNumber);
            System.out.println("\n Is the above mobile number valid?" + mobileNumber.matches(regex));
            System.out.println("Please Check and Confirm " + mobileNumber);
            System.out.println("1. Yes");
            System.out.println("2. NO");

            Scanner sr = new Scanner(System.in);
            int opt = sc.nextInt();
            if (opt == 1) {
                accountNumberValidation(); //account number validation
            } else if (opt == 2) {
                mobileNumberValidation();
            }
            System.out.println();
        }
    }

    //for account Number Validation
    public void accountNumberValidation() {

        Scanner sc = new Scanner(System.in);
        String accountNumber = null;
        int x;
        for (x = 0; x <= 3; x++) {
            System.out.println("Enter your Account number");
            accountNumber = sc.next();
            String regex = "\\d{14}";
            System.out.println("\n The Mobile Number is:" + accountNumber);
            System.out.println("\n Is the above mobile number valid?" + accountNumber.matches(regex));
            System.out.println("Please Check and Confirm " + accountNumber);
            System.out.println("1. Yes");

            System.out.println("2. NO");

            Scanner sr = new Scanner(System.in);
            int opt = sc.nextInt();
            if (opt == 1) {
                processToMoney();
            } else if (opt == 2) {
                accountNumberValidation();
            }
            System.out.println();
        }
    }
    // Process for TransferMoney
    public void processToMoney() {

        System.out.println("Enter the amount");
        Scanner sc = new Scanner(System.in);
        double transferAmount = sc.nextFloat();
        transactionsList.add(" -- " + transferAmount + " -- " + "Transfer Money" + "\n");
        System.out.println("Please check The Amount" + transferAmount);
        if (transferAmount > balance) {
            System.out.println("Insufficient Balance");
            System.out.println();
            menu();

        } else {
            balance = balance - transferAmount;
            System.out.println("Money Transfer Successful");
        }
        System.out.println();
        menu();
    }

    //for exit or quit
    public void quit() {
        System.exit(0);
    }
}
