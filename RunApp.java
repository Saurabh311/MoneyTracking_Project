package Shapes;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class RunApp {
    Scanner scan = new Scanner(System.in);
    int balance;
    ArrayList<Transactions> transactionList;
    FileHandler fh = new FileHandler();
    AppBoard app = new AppBoard();

    RunApp()
    {
        transactionList = fh.readFile();
    }
    void startApp() throws InterruptedException, IOException, ClassNotFoundException {
        boolean appOn = true;
        boolean success;
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
                    success = app.addOrRemove(transactionList,Operation.ADD,0);
                    if(success){
                        System.out.println("Operation is completed successfully ");
                        fh.writeFile(transactionList);
                    }
                    break;

                case 3:
                    Operation action = Operation.INVALID;
                    app.listItem(transactionList,Transcation.SHOWALLTRANSCATIONS);
                    System.out.println("Please enter S.no of item to be edit or remove");
                    int choose = scan.nextInt();
                    System.out.println("For delete this item press 1 or press 2 for edit ");
                    int isRemove = scan.nextInt();
                    action =   isRemove == 1 ? Operation.REMOVE : Operation.EDIT;
                    success = app.addOrRemove(transactionList, action, choose);
                    if(success){
                        System.out.println("Operation is completed successfully ");
                    }
                    break;

                case 4:
                    System.out.println("You choose to quite. Thankyou and welcome again\n");
                    fh.writeFile(transactionList);
                    appOn = false;
                    break;

                default:
                    System.out.println("No valid choice, try again\n");
            }
        }
    }

}
