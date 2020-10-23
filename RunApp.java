package moneytrackerapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class RunApp {
    Scanner scan = new Scanner(System.in);
    int balance;
    ArrayList<Transactions> transactionList;
    FileHandler fh = new FileHandler();
    AppBoard app = new AppBoard();

    RunApp() {
        transactionList = fh.readFile();
    }
    // This function handles the addition, modification, removal of the transcations in the app
    void startApp() throws InterruptedException, IOException, ClassNotFoundException, InputMismatchException {
        boolean appOn = true;
        boolean success = false;
        System.out.println("Welcome to TrackMoney");
            while (appOn) { // display the menu, take user input and revert
                balance = app.getBalance(transactionList);
                System.out.println("You have currently " + balance + " kr on your account \nPick an option : \n(1) Show Items (All/Expenses(s)/Income(s) \n(2) Add New Expense/Income \n(3) Edit Item (Edit, Remove)\n(4) Save and Quit");
                int option = scan.nextInt();
                switch (option) {
                    case 1:
                        app.showTransactions(transactionList);
                        break;
                    case 2:
                        success = app.addItem(transactionList);
                        break;
                    case 3:
                        success = app.removeOrEditItem(transactionList);
                        break;
                    case 4:
                        System.out.println("You choose to quite. Thankyou and welcome again\n");
                        fh.writeFile(transactionList); // Save the data before closing the app
                        appOn = false;
                        break;
                    default:
                        System.out.println("No valid choice, try again\n");
                }
                if(success)
                {
                    fh.writeFile(transactionList);
                }
            }
    }

}